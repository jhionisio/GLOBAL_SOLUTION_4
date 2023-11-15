package life.assisten.forall.emergencyContacts.controller.converters;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import life.assisten.forall.emergencyContacts.controller.dto.EmergencyContactsDTO;
import life.assisten.forall.emergencyContacts.domain.EmergencyContactsDomain;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class EmergencyContactsToDTO {

    private final ModelMapper modelMapper;

    public EmergencyContactsDTO convertToDTO(EmergencyContactsDomain domain) {
        return modelMapper.map(domain, EmergencyContactsDTO.class);
    }
}
