package life.assisten.forall.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import life.assisten.forall.patient.domain.PatientDomain;
import life.assisten.forall.patient.repository.PatientRepository;

import java.util.Date;

@Component
public class DefaultUserInitializer implements ApplicationListener<ContextRefreshedEvent> {

    private final PatientRepository patientRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DefaultUserInitializer(PatientRepository patientRepository, PasswordEncoder passwordEncoder) {
        this.patientRepository = patientRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (patientRepository.findByEmail("default@user.com").isEmpty()) {
            PatientDomain defaultPatient = PatientDomain.builder()
                    .nmPaciente("Default Patient")
                    .nmDoencasCronicas("Hypertension")
                    .nrCpf("12345678901")
                    .dtNascimento(new Date())
                    .sexo('M')
                    .password("default")
                    .nmEndereco("123 Main St, City")
                    .nrTelefone("1441-7890")
                    .email("default@user.com")
                    .build();
            String senhaCodificada = passwordEncoder.encode(defaultPatient.getPassword());
            defaultPatient.setPassword(senhaCodificada);
            patientRepository.save(defaultPatient);
        }
    }

}
