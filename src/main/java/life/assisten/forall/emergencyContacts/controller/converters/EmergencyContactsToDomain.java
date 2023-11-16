package life.assisten.forall.emergencyContacts.controller.converters;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import life.assisten.forall.emergencyContacts.controller.dto.EmergencyContactsDTO;
import life.assisten.forall.emergencyContacts.domain.EmergencyContactsDomain;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class EmergencyContactsToDomain {

    private final ModelMapper modelMapper;

    public EmergencyContactsDomain convertToDomain(EmergencyContactsDTO dto) {
        return modelMapper.map(dto, EmergencyContactsDomain.class);
    }
}
