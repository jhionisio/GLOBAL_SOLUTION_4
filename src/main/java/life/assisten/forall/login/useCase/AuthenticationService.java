package life.assisten.forall.login.useCase;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import life.assisten.forall.doctor.repository.DoctorRepository;
import life.assisten.forall.patient.repository.PatientRepository;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    PatientRepository patientRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        CompletableFuture<Optional<UserDetails>> doctorFuture = CompletableFuture
                .supplyAsync(() -> doctorRepository.findByEmail(email)
                        .map(doctor -> (UserDetails) doctor));

        CompletableFuture<Optional<UserDetails>> patientFuture = CompletableFuture
                .supplyAsync(() -> patientRepository.findByEmail(email)
                        .map(patient -> (UserDetails) patient));

        return CompletableFuture.anyOf(doctorFuture, patientFuture)
                .thenApplyAsync(userDetails -> {
                    Optional<UserDetails> userDetailsOptional = (Optional<UserDetails>) userDetails;
                    return userDetailsOptional
                            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
                }).join();
    }
}
