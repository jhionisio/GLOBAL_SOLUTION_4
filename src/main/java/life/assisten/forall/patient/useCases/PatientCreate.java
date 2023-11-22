package life.assisten.forall.patient.useCases;

import life.assisten.forall.patient.controller.converter.PatientToDomain;
import life.assisten.forall.patient.controller.dto.PatientDTO;
import life.assisten.forall.patient.domain.PatientDomain;
import life.assisten.forall.patient.repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service

public class PatientCreate {

    private final PatientRepository patientRepository;
    private final PatientToDomain converter;

    public PatientCreate(PatientRepository patientRepository, PatientToDomain converter) {
        this.patientRepository = patientRepository;
        this.converter = converter;
    }

    public PatientDomain createPatient(PatientDTO patientDTO) {
        PatientDomain patientDomain = converter.convertToDomain(patientDTO);
        return patientRepository.save(patientDomain);
    }
}
