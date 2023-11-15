package life.assisten.forall.login.useCase;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import life.assisten.forall.doctor.domain.DoctorDomain;
import life.assisten.forall.login.domain.Credencial;
import life.assisten.forall.login.domain.Token;
import life.assisten.forall.patient.domain.PatientDomain;

@Service
public class TokenService {

    @Autowired
    life.assisten.forall.doctor.repository.DoctorRepository DoctorRepository;
    life.assisten.forall.patient.repository.PatientRepository PatientRepository;

    @Value("${jwt.secret}")
    String secret;

    public Token generateToken(Credencial credencial) {
        Algorithm alg = Algorithm.HMAC256(secret);
        var token = JWT.create()
                .withSubject(credencial.email())
                .withExpiresAt(Instant.now().plus(1, ChronoUnit.HOURS))
                .withIssuer("forall")
                .sign(alg);

        return new Token(token, "JWT", "Bearer");
    }

    public PatientDomain valideAndGetPatientBy(String token) {
        Algorithm alg = Algorithm.HMAC256(secret);
        var email = JWT.require(alg)
                .withIssuer("forall")
                .build()
                .verify(token)
                .getSubject();

        return PatientRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public DoctorDomain valideAndGetDoctorBy(String token) {
        Algorithm alg = Algorithm.HMAC256(secret);
        var email = JWT.require(alg)
                .withIssuer("forall")
                .build()
                .verify(token)
                .getSubject();

        return DoctorRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

}
