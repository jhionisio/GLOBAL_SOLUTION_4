package life.assisten.forall.patient.controller;

import life.assisten.forall.patient.controller.dto.PatientDTO;
import life.assisten.forall.patient.useCases.PatientCreate;
import life.assisten.forall.patient.useCases.PatientList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    private final PatientCreate patientCreate;
    private final PatientList patientList;

    public PatientController(PatientCreate patientCreate, PatientList patientList) {
        this.patientCreate = patientCreate;
        this.patientList = patientList;
    }

    @PostMapping
    public ResponseEntity<?> createPatient(@Valid @RequestBody PatientDTO dto) {
        patientCreate.createPatient(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<PatientDTO>> listPatients() {
        List<PatientDTO> patients = patientList.listPatients();
        return ResponseEntity.status(HttpStatus.OK).body(patients);
    }

    @CrossOrigin(origins = "http://localhost:19006") // Especifique a origem permitida
    @GetMapping("/id/{idPaciente}")
    public ResponseEntity<PatientDTO> findPatientById(@PathVariable Integer idPaciente) {
        PatientDTO patient = patientList.findPatientById(idPaciente);
        return ResponseEntity.status(HttpStatus.OK).body(patient);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<PatientDTO> findPatientByEmail(@PathVariable String email) {
        PatientDTO patient = patientList.findPatientByEmail(email);
        return ResponseEntity.status(HttpStatus.OK).body(patient);
    }
}
