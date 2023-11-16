package life.assisten.forall.emergencyContacts.useCases;

import org.springframework.stereotype.Service;

import life.assisten.forall.emergencyContacts.controller.converters.EmergencyContactsToDomain;
import life.assisten.forall.emergencyContacts.controller.dto.EmergencyContactsDTO;
import life.assisten.forall.emergencyContacts.domain.EmergencyContactsDomain;
import life.assisten.forall.emergencyContacts.repository.EmergencyContactsRepository;

@Service
public class EmergencyContactsCreate {

    private final EmergencyContactsRepository emergencyContactsRepository;
    private final EmergencyContactsToDomain converter;

    public EmergencyContactsCreate(EmergencyContactsRepository emergencyContactsRepository,
            EmergencyContactsToDomain converter) {
        this.emergencyContactsRepository = emergencyContactsRepository;
        this.converter = converter;
    }

    public EmergencyContactsDomain createEmergencyContacts(EmergencyContactsDTO emergencyContactsDTO) {
        EmergencyContactsDomain emergencyContactsDomain = converter.convertToDomain(emergencyContactsDTO);
        return emergencyContactsRepository.save(emergencyContactsDomain);
    }
}
