/*
package com.pfe.myschool.Session;

import com.pfe.myschool.service.MyUserDetailsService;
import com.pfe.myschool.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

@AllArgsConstructor
@Component
public class SessionFilter extends OncePerRequestFilter {

    private final InMemorySession sessionRegistrey;
    private final MyUserDetailsService userDetailsService;
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain Chain) throws ServletException, IOException {

      final   String sessionID = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (sessionID==null || sessionID.length()==0 ){
            Chain.doFilter(request,response);
            return;
        }
        final String username=sessionRegistrey.getUsernameForSession(sessionID);
        if (username==null){
            Chain.doFilter(request,response);
            return;
        }
       final UserDetails currentUser  = userDetailsService.loadUserByUsername(username);
       final UsernamePasswordAuthenticationToken authenticationToken =new UsernamePasswordAuthenticationToken(
                currentUser,null,currentUser.getAuthorities()
        )  ;
        try {
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            Chain.doFilter(request, response);
        } catch (Exception e) {
            // Log the exception for debugging
            logger.error("Error processing authentication details", e);
            throw new AuthenticationServiceException("Error processing authentication details", e);
        }
    }

}
*/
