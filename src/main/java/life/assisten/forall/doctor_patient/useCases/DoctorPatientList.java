package life.assisten.forall.doctor_patient.useCases;

import org.springframework.stereotype.Service;

import life.assisten.forall.doctor_patient.controller.converters.DoctorPatientToDto;
import life.assisten.forall.doctor_patient.controller.dto.DoctorPatientDTO;
import life.assisten.forall.doctor_patient.domain.DoctorPatientDomain;
import life.assisten.forall.doctor_patient.repository.DoctorPatientRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorPatientList {

    private DoctorPatientRepository repository;
    private DoctorPatientToDto converter;

    public DoctorPatientList(DoctorPatientRepository repository, DoctorPatientToDto converter) {
        this.repository = repository;
        this.converter = converter;
    }

    public List<DoctorPatientDTO> listDoctorPatient() {
        List<DoctorPatientDomain> doctorDomains = repository.findAll();
        return doctorDomains.stream()
                .map(converter::convertToDTO)
                .collect(Collectors.toList());
    }

}
