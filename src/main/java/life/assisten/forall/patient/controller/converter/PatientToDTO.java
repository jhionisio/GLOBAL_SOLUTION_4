package life.assisten.forall.patient.controller.converter;

import life.assisten.forall.patient.controller.dto.PatientDTO;
import life.assisten.forall.patient.domain.PatientDomain;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PatientToDTO {
    private final ModelMapper modelMapper;

    public PatientDTO convertToDTO(PatientDomain domain) {
        return modelMapper.map(domain, PatientDTO.class);
    }
}
