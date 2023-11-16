package life.assisten.forall.login.useCase;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import life.assisten.forall.doctor.repository.DoctorRepository;
import life.assisten.forall.login.domain.Credencial;
import life.assisten.forall.login.domain.Token;
import life.assisten.forall.patient.domain.PatientDomain;
import life.assisten.forall.patient.repository.PatientRepository;

@Service
public class TokenService {

        @Autowired
        PatientRepository patientRepository;

        @Autowired
        DoctorRepository doctorRepository;

        @Value("${jwt.secret}")
        String secret;

        public Token generateToken(Credencial credencial) {
                Algorithm alg = Algorithm.HMAC256(secret);
                var token = JWT.create()
                                .withSubject(credencial.email())
                                .withExpiresAt(Instant.now().plus(1, ChronoUnit.HOURS))
                                .withIssuer("ForAll")
                                .sign(alg);

                return new Token(token, "JWT", "Bearer");
        }

        public PatientDomain valideAndGetUserBy(String token) {
                Algorithm alg = Algorithm.HMAC256(secret);
                var email = JWT.require(alg)
                                .withIssuer("ForAll")
                                .build()
                                .verify(token)
                                .getSubject();

                return patientRepository.findByEmail(email)
                                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        }

}
