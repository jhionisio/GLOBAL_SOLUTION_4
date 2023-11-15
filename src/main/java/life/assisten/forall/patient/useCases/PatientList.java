package life.assisten.forall.patient.useCases;

import life.assisten.forall.patient.controller.converter.PatientToDTO;
import life.assisten.forall.patient.controller.dto.PatientDTO;
import life.assisten.forall.patient.domain.PatientDomain;
import life.assisten.forall.patient.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientList {

    private final PatientRepository patientRepository;
    private final PatientToDTO converter;

    public PatientList(PatientRepository patientRepository, PatientToDTO converter) {
        this.patientRepository = patientRepository;
        this.converter = converter;
    }

    public List<PatientDTO> listPatients() {
        List<PatientDomain> patientDomains = patientRepository.findAll();
        return patientDomains.stream()
                .map(converter::convertToDTO)
                .collect(Collectors.toList());
    }

    public PatientDTO findPatientById(Integer idPaciente) {
        Optional<PatientDomain> optionalPatientDomain = patientRepository.findByIdPaciente(idPaciente);
        return optionalPatientDomain.map(converter::convertToDTO).orElse(null);
    }

    public PatientDTO findPatientByEmail(String email) {
        Optional<PatientDomain> optionalPatientDomain = patientRepository.findByEmail(email);
        return optionalPatientDomain.map(converter::convertToDTO).orElse(null);
    }
}
