package life.assisten.forall.doctor_patient.controller.converters;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import life.assisten.forall.doctor_patient.controller.dto.DoctorPatientDTO;
import life.assisten.forall.doctor_patient.domain.DoctorPatientDomain;

@Component
public class DoctorPatientToDomain {

    private ModelMapper modelMapper;

    public void DoctorPatientConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public DoctorPatientDomain convertToEntity(DoctorPatientDTO dto) {
        return modelMapper.map(dto, DoctorPatientDomain.class);
    }

}
