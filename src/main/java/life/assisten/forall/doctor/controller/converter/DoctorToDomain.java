package life.assisten.forall.doctor.controller.converter;

import life.assisten.forall.doctor.domain.DoctorDomain;
import life.assisten.forall.doctor.controller.dto.DoctorDTO;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DoctorToDomain {
    private final ModelMapper modelMapper;

    public DoctorDomain convertToDomain(DoctorDTO dto) {
        return modelMapper.map(dto, DoctorDomain.class);
    }

    public DoctorDomain convertToDomainOptional(Optional<DoctorDomain> optional) {
        return modelMapper.map(optional, DoctorDomain.class);
    }
}
