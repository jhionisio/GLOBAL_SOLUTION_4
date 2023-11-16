package life.assisten.forall.doctor_patient.controller.converters;

import org.modelmapper.ModelMapper;

import life.assisten.forall.doctor_patient.controller.dto.DoctorPatientDTO;
import life.assisten.forall.doctor_patient.domain.DoctorPatientDomain;

public class DoctorPatientToDTO {

    private ModelMapper modelMapper;

    public void DoctorPatientConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public DoctorPatientDTO convertToDTO(DoctorPatientDomain entity) {
        return modelMapper.map(entity, DoctorPatientDTO.class);
    }

}
