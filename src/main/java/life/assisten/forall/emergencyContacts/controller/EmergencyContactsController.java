package life.assisten.forall.emergencyContacts.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import life.assisten.forall.emergencyContacts.controller.dto.EmergencyContactsDTO;
import life.assisten.forall.emergencyContacts.useCases.EmergencyContactsCreate;
import life.assisten.forall.emergencyContacts.useCases.EmergencyContactsList;

import java.util.List;

@RestController
@RequestMapping("/emergency-contacts")
public class EmergencyContactsController {

    private final EmergencyContactsCreate emergencyContactsCreate;
    private final EmergencyContactsList emergencyContactsList;

    public EmergencyContactsController(EmergencyContactsCreate emergencyContactsCreate,
            EmergencyContactsList emergencyContactsList) {
        this.emergencyContactsCreate = emergencyContactsCreate;
        this.emergencyContactsList = emergencyContactsList;
    }

    @PostMapping
    public ResponseEntity<?> createEmergencyContacts(@Valid @RequestBody EmergencyContactsDTO dto) {
        emergencyContactsCreate.createEmergencyContacts(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<EmergencyContactsDTO>> listEmergencyContactss() {
        List<EmergencyContactsDTO> emergencyContactss = emergencyContactsList.listEmergencyContactss();
        return ResponseEntity.status(HttpStatus.OK).body(emergencyContactss);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmergencyContactsDTO> findEmergencyContactsById(@PathVariable Integer id) {
        EmergencyContactsDTO emergencyContacts = emergencyContactsList.findByIdContatos(id);
        return ResponseEntity.status(HttpStatus.OK).body(emergencyContacts);
    }
}
