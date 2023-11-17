package life.assisten.forall.doctor_patient.controller.converters;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import life.assisten.forall.doctor_patient.controller.dto.DoctorPatientDTO;
import life.assisten.forall.doctor_patient.domain.DoctorPatientDomain;

@Component
public class DoctorPatientToDTO {

    private final ModelMapper modelMapper;

    public DoctorPatientToDTO(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public DoctorPatientDTO convertToDTO(DoctorPatientDomain entity) {
        return modelMapper.map(entity, DoctorPatientDTO.class);
    }
}
