package com.learning.tweety.authserver.securityconfig;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.learning.tweety.authserver.service.JWTTokeService;
import com.learning.tweety.authserver.service.UserDetailsService;

@Component
public class JWTFilter extends OncePerRequestFilter {
	@Autowired
	public JWTTokeService jwtTokenService;

	@Autowired
	public UserDetailsService userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		HttpServletRequest req = (HttpServletRequest) request;
		String path = req.getRequestURI();
		if (!path.contains("/getaccesstoken")) {
			String jwt = getJwtFromRequest(req);
			if (!StringUtils.hasText(jwt) || !jwtTokenService.isValidToken(jwt)) {
				throw new ServletException("Unauthorized Entry.");
			}
		} else {
			if(!validateUser(req)) {
				throw new ServletException("Invalid User.");
			}
		}
        filterChain.doFilter(request, response);
	}

	private String getJwtFromRequest(HttpServletRequest request) {
		String bearerToken = request.getHeader("Authorization");
		if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
			return bearerToken.substring(7, bearerToken.length());
		}
		return null;
	}

	private boolean validateUser(HttpServletRequest request) {
		String decoded = new String(DatatypeConverter.parseBase64Binary(getBasicHeaderFromRequest(request)));
		int seperatorIndex = decoded.indexOf(':');
		String username = decoded.substring(0, seperatorIndex);
		String password = decoded.substring(seperatorIndex + 1);
		return userDetailsService.isValidUser(username, password);
	}

	private String getBasicHeaderFromRequest(HttpServletRequest request) {
		String basicToken = request.getHeader("Authorization");
		if (StringUtils.hasText(basicToken) && basicToken.startsWith("Basic ")) {
			return basicToken.substring(6, basicToken.length());
		}
		return null;
	}

}
