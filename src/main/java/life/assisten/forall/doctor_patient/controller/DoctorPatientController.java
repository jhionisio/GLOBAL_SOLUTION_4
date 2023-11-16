package life.assisten.forall.doctor_patient.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import life.assisten.forall.doctor_patient.useCases.DoctorPatientCreate;

@RestController
@RequestMapping("/doctor-patient")
public class DoctorPatientController {

    private final DoctorPatientCreate doctorPatientCreate;

    public DoctorPatientController(DoctorPatientCreate doctorPatientCreate) {
        this.doctorPatientCreate = doctorPatientCreate;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createDoctorPatientRelationship(
            @RequestParam Integer doctorId,
            @RequestParam Integer patientId) {

        doctorPatientCreate.createDoctorPatient(doctorId, patientId);
        return ResponseEntity.ok("Doctor-Patient relationship created successfully");
    }
}
