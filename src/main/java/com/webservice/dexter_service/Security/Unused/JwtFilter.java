package com.webservice.dexter_service.Security.Unused;

import java.io.IOException;

import javax.security.sasl.AuthenticationException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.webservice.dexter_service.Common.Enums.Enums;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.util.StringUtils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

//Klasa nieużywana
public class JwtFilter implements Filter {

    @ReadOnlyProperty
    @Value("${jwt.signing-key}")
    private static String SIGNING_KEY;

    public static String getSigningKey() {
        return SIGNING_KEY;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String header = httpServletRequest.getHeader("Authorization");
        if (StringUtils.isEmpty(header)) {
            throw new AuthenticationException("Empty header");
        } else if (!header.startsWith("Bearer")) {
            throw new AuthenticationException("Wrong header");
        } else {
            try {
                String token = header.replaceAll("Bearer ", "");
                Claims claims = Jwts.parser().setSigningKey(Enums.TEXTS.PASSWORD).parseClaimsJws(token).getBody();
                request.setAttribute(Enums.TEXTS.CLAIMS, claims);
            } catch (Exception e) {
                throw new ServletException(e);
            }
        }
        chain.doFilter(request, response);
    }

}
