package life.assisten.forall.doctor.controller.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import life.assisten.forall.doctor.controller.dto.DoctorDTO;
import life.assisten.forall.doctor.domain.DoctorDomain;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DoctorToDTO {
    private final ModelMapper modelMapper;

    public DoctorDTO convertToDTO(DoctorDomain domain) {
        return modelMapper.map(domain, DoctorDTO.class);
    }
}
