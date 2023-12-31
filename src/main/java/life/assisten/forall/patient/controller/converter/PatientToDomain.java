package life.assisten.forall.patient.controller.converter;

import life.assisten.forall.patient.controller.dto.PatientDTO;
import life.assisten.forall.patient.domain.PatientDomain;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class PatientToDomain {
    private final ModelMapper modelMapper;

    public PatientDomain convertToDomain(PatientDTO dto) {
        return modelMapper.map(dto, PatientDomain.class);
    }

    public PatientDomain convertToDomainOptional(Optional<PatientDomain> optional) {
        return modelMapper.map(optional, PatientDomain.class);
    }
}
