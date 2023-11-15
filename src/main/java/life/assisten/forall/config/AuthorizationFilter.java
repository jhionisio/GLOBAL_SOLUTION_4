package life.assisten.forall.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import life.assisten.forall.login.useCase.TokenService;
import life.assisten.forall.patient.domain.PatientDomain;
import life.assisten.forall.doctor.domain.DoctorDomain;

@Component
public class AuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        var token = getToken(request);

        if (token != null) {
            DoctorDomain doctor = tokenService.valideAndGetDoctorBy(token);
            if (doctor == null) {
                PatientDomain patient = tokenService.valideAndGetPatientBy(token);
                if (patient != null) {
                    Authentication auth = new UsernamePasswordAuthenticationToken(patient.getEmail(), null,
                            patient.getAuthorities());
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            } else {
                Authentication auth = new UsernamePasswordAuthenticationToken(doctor.getEmail(), null,
                        doctor.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
        filterChain.doFilter(request, response);
    }

    private String getToken(HttpServletRequest request) {
        String prefix = "Bearer ";
        var header = request.getHeader("Authorization");

        if (header == null || header.isEmpty() || !header.startsWith(prefix)) {
            return null;
        }

        return header.replace(prefix, "");
    }
}
