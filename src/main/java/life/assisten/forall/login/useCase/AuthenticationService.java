package life.assisten.forall.login.useCase;

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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return doctorRepository.findByEmail(username)
                .map(doctor -> (UserDetails) doctor)
                .orElseGet(() -> {
                    return patientRepository.findByEmail(username)
                            .map(patient -> (UserDetails) patient)
                            .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
                });
    }
}
