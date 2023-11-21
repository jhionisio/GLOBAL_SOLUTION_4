package life.assisten.forall.doctor_patient.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import life.assisten.forall.doctor_patient.controller.dto.DoctorPatientDTO;
import life.assisten.forall.doctor_patient.useCases.DoctorPatientCreate;
import life.assisten.forall.doctor_patient.useCases.DoctorPatientList;

import java.util.List;

@RestController
@RequestMapping("/doctor-patient")
public class DoctorPatientController {

    private final DoctorPatientList doctorPatientList;
    private final DoctorPatientCreate doctorPatientCreate;

    public DoctorPatientController(DoctorPatientList doctorPatientList, DoctorPatientCreate doctorPatientCreate) {
        this.doctorPatientList = doctorPatientList;
        this.doctorPatientCreate = doctorPatientCreate;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createDoctorPatientRelationship(
            @RequestParam Integer doctorId,
            @RequestParam Integer patientId) {

        doctorPatientCreate.createDoctorPatient(doctorId, patientId);
        return ResponseEntity.ok("Doctor-Patient relationship created successfully");
    }

    @GetMapping("/list")
    public ResponseEntity<List<DoctorPatientDTO>> listDoctorPatients() {
        List<DoctorPatientDTO> doctorPatients = doctorPatientList.listDoctorPatient();
        return ResponseEntity.ok(doctorPatients);
    }

}
