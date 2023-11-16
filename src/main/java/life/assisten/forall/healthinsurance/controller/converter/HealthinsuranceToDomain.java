package life.assisten.forall.healthinsurance.controller.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import life.assisten.forall.healthinsurance.controller.dto.HealthinsuranceDTO;
import life.assisten.forall.healthinsurance.domain.HealthinsuranceDomain;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class HealthinsuranceToDomain {

    private final ModelMapper modelMapper;

    public HealthinsuranceDomain convertToDomain(HealthinsuranceDTO dto) {
        return modelMapper.map(dto, HealthinsuranceDomain.class);
    }
}