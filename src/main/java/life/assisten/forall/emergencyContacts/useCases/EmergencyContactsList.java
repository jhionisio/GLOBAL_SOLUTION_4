package life.assisten.forall.emergencyContacts.useCases;

import org.springframework.stereotype.Service;

import life.assisten.forall.emergencyContacts.controller.converters.EmergencyContactsToDTO;
import life.assisten.forall.emergencyContacts.controller.dto.EmergencyContactsDTO;
import life.assisten.forall.emergencyContacts.domain.EmergencyContactsDomain;
import life.assisten.forall.emergencyContacts.repository.EmergencyContactsRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmergencyContactsList {

    private final EmergencyContactsRepository emergencyContactsRepository;
    private final EmergencyContactsToDTO converter;

    public EmergencyContactsList(EmergencyContactsRepository emergencyContactsRepository,
            EmergencyContactsToDTO converter) {
        this.emergencyContactsRepository = emergencyContactsRepository;
        this.converter = converter;
    }

    public List<EmergencyContactsDTO> listEmergencyContactss() {
        List<EmergencyContactsDomain> emergencyContactsDomains = emergencyContactsRepository.findAll();
        return emergencyContactsDomains.stream()
                .map(converter::convertToDTO)
                .collect(Collectors.toList());
    }

    public EmergencyContactsDTO findByIdContatos(Integer idMedico) {
        Optional<EmergencyContactsDomain> emergencyContactsOptional = emergencyContactsRepository
                .findByIdContatos(idMedico);
        return emergencyContactsOptional.map(converter::convertToDTO).orElse(null);
    }
}
