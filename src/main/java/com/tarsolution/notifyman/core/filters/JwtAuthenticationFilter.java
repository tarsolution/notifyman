/*
 * Copyright (C) 2011 The Best Company in the World
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * https://github.com/fmarslan/notifyman/blob/master/LICENSE
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tarsolution.notifyman.core.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import com.tarsolution.notifyman.core.authorization.TokenService;
import com.tarsolution.notifyman.data.entity.AuthorizationCode;
import com.tarsolution.notifyman.data.entity.Token;
/**
 * 
 * @author FMARSLAN
 *
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  private final String TOKEN_PREFIX;
  private final String HEADER_NAME;

  public JwtAuthenticationFilter(String tokenPrefix, String headerName) {
    TOKEN_PREFIX=tokenPrefix;
    HEADER_NAME=headerName;
  }
  
  @Autowired
  TokenService tokenService;

  @Override
  protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res,
      FilterChain chain)
      throws IOException, ServletException {

    String authToken = null;
    String header = req.getHeader(HEADER_NAME);
    Token token = new Token();

    if (header != null && header.startsWith(TOKEN_PREFIX)) {
      authToken = header.replace(TOKEN_PREFIX, "");
      if (!StringUtils.isEmpty(authToken)) {
        token = tokenService.findToken(authToken);
      } else {
        logger.warn("Authtoken bulunamadı.");
      }
    } else {
      logger.warn("Bearer stringi bulunamadı.");
    }
    if (token != null && SecurityContextHolder.getContext().getAuthentication() == null) {

      if (token.getAuthorizationCodes() != null && token.getAuthorizationCodes().size() > 0) {
        List<AuthorizationCode> acList = token.getAuthorizationCodes();
        @SuppressWarnings("unchecked") final Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) getAuthorities(
            acList);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
            token, "",
            authorities);
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
        SecurityContextHolder.getContext().setAuthentication(authentication);
      }
    }

    chain.doFilter(req, res);
  }

  private Collection<? extends GrantedAuthority> getAuthorities(List<AuthorizationCode> roles) {
    List<GrantedAuthority> authorities = new ArrayList<>();
    for (AuthorizationCode role : roles) {
      authorities.add(new SimpleGrantedAuthority(role.getAuthCode()));
    }
    return authorities;
  }
}
