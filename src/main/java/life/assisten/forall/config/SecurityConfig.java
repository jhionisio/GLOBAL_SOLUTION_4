package life.assisten.forall.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    Environment env;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.POST, "/patient").permitAll()
                .requestMatchers(HttpMethod.GET, "/patient/id").permitAll()
                .requestMatchers(HttpMethod.POST, "/diary").permitAll()
                .requestMatchers(HttpMethod.PUT, "/diary").permitAll()
                .requestMatchers(HttpMethod.DELETE, "/diary").permitAll()
                .requestMatchers(HttpMethod.GET, "/diary/list").permitAll()
                .requestMatchers(HttpMethod.POST, "/doctor").permitAll()
                .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                .requestMatchers("/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**").permitAll()

                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .headers().frameOptions().sameOrigin();

        if (env.getActiveProfiles().length > 0 && env.getActiveProfiles()[0].equals("open")) {
            http.authorizeHttpRequests().anyRequest().permitAll();
        } else {
            http.authorizeHttpRequests().anyRequest().authenticated();
        }

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}