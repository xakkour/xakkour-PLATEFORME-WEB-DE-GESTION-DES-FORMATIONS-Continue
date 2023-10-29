
    package com.pfe.myschool.Security;

    import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
    import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
    import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
    import org.springframework.security.config.annotation.web.builders.HttpSecurity;
    import org.springframework.security.config.http.SessionCreationPolicy;
    import org.springframework.security.core.session.SessionRegistryImpl;
    import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
    import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
    import org.springframework.web.cors.CorsConfiguration;
    import org.springframework.web.cors.CorsConfigurationSource;
    import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
    import org.springframework.web.servlet.config.annotation.CorsRegistry;

    import java.util.Collections;

    @KeycloakConfiguration
    @EnableGlobalMethodSecurity(prePostEnabled = true)
    public class SecurityConfig extends KeycloakWebSecurityConfigurerAdapter {
        @Override
        protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {


            return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.authenticationProvider(keycloakAuthenticationProvider());
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            super.configure(http);
            http.csrf().disable().cors().and().authorizeRequests()
                    .antMatchers("/swagger-ui/**",
                            "/swagger-resources/*",
                            "/v3/api-docs/**").permitAll();
            http.authorizeRequests().anyRequest().authenticated();

        }

        //@Bean
        public CorsConfigurationSource corsConfigurationSource() {
            CorsConfiguration corsConfig = new CorsConfiguration();
            corsConfig.setAllowedOrigins(Collections.singletonList("http://localhost:4200/*"));
            corsConfig.setAllowedMethods(Collections.singletonList("*")); // Allow all HTTP methods
            corsConfig.setAllowCredentials(true);
            corsConfig.setAllowedHeaders(Collections.singletonList("*")); // Allow all headers

            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", corsConfig);

            return source;
        }
    }

/*
            super.configure(http);
            http.csrf().disable().cors().and().authorizeRequests()
                    .antMatchers("/api").permitAll();
            http.authorizeRequests().antMatchers("/api/**").permitAll();
            http.authorizeRequests().antMatchers("/**").permitAll();
            http.headers().frameOptions().disable();

            http.authorizeRequests().anyRequest().authenticated();

            http.cors().configurationSource(corsConfigurationSource());

        }
        private CorsConfigurationSource corsConfigurationSource() {
            CorsConfiguration corsConfiguration = new CorsConfiguration();
            corsConfiguration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
            corsConfiguration.setAllowedMethods(Collections.singletonList("POST"));
            corsConfiguration.setAllowCredentials(true);
            corsConfiguration.setAllowedHeaders(Collections.singletonList("*"));

            return request -> corsConfiguration;
        }



    }*/




