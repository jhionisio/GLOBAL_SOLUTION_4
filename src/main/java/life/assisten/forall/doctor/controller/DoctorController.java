package life.assisten.forall.doctor.controller;

import life.assisten.forall.doctor.controller.dto.DoctorDTO;
import life.assisten.forall.doctor.useCases.DoctorCreate;
import life.assisten.forall.doctor.useCases.DoctorList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private final DoctorCreate doctorCreate;
    private final DoctorList doctorList;

    public DoctorController(DoctorCreate doctorCreate, DoctorList doctorList) {
        this.doctorCreate = doctorCreate;
        this.doctorList = doctorList;
    }

    @PostMapping
    public ResponseEntity<?> createDoctor(@Valid @RequestBody DoctorDTO dto) {
        doctorCreate.createDoctor(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<DoctorDTO>> listDoctors() {
        List<DoctorDTO> doctors = doctorList.listDoctors();
        return ResponseEntity.status(HttpStatus.OK).body(doctors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDTO> findDoctorById(@PathVariable Integer id) {
        DoctorDTO doctor = doctorList.findDoctorById(id);
        return ResponseEntity.status(HttpStatus.OK).body(doctor);
    }
}
