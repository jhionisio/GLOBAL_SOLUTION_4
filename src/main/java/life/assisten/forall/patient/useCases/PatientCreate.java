package life.assisten.forall.patient.useCases;

import org.springframework.security.crypto.password.PasswordEncoder;

import life.assisten.forall.patient.controller.converter.PatientToDomain;
import life.assisten.forall.patient.controller.dto.PatientDTO;
import life.assisten.forall.patient.domain.PatientDomain;
import life.assisten.forall.patient.repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service

public class PatientCreate {

    private final PatientRepository patientRepository;
    private final PatientToDomain converter;
    private final PasswordEncoder passwordEncoder;

    public PatientCreate(PatientRepository patientRepository, PatientToDomain converter,
            PasswordEncoder passwordEncoder) {
        this.patientRepository = patientRepository;
        this.converter = converter;
        this.passwordEncoder = passwordEncoder;
    }

    public PatientDomain createPatient(PatientDTO patientDTO) {
        PatientDomain patientDomain = converter.convertToDomain(patientDTO);
        String senhaCodificada = passwordEncoder.encode(patientDomain.getPassword());
        patientDomain.setPassword(senhaCodificada);
        return patientRepository.save(patientDomain);
    }
}
