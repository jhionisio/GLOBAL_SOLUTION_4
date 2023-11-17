package life.assisten.forall.healthinsurance.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import life.assisten.forall.healthinsurance.controller.dto.HealthinsuranceDTO;
import life.assisten.forall.healthinsurance.useCases.HealthinsuranceCreate;
import life.assisten.forall.healthinsurance.useCases.HealthinsuranceList;

@RestController
@RequestMapping("/healthinsurance")
public class HealthinsuranceController {

    private final HealthinsuranceCreate healthinsuranceCreate;
    private final HealthinsuranceList healthinsuranceList;

    public HealthinsuranceController(HealthinsuranceCreate healthinsuranceCreate,
            HealthinsuranceList healthinsuranceList) {
        this.healthinsuranceCreate = healthinsuranceCreate;
        this.healthinsuranceList = healthinsuranceList;
    }

    @PostMapping
    public ResponseEntity<?> createHealthinsurance(@Valid @RequestBody HealthinsuranceDTO dto) {
        healthinsuranceCreate.createHealthInsurance(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<HealthinsuranceDTO>> listHealthinsurances() {
        List<HealthinsuranceDTO> healthinsurances = healthinsuranceList.listHealthinsurances();
        return ResponseEntity.status(HttpStatus.OK).body(healthinsurances);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HealthinsuranceDTO> findhealthinsuranceById(@PathVariable Integer id) {
        HealthinsuranceDTO healthinsurance = healthinsuranceList.findHealthinsuranceById(id);
        return ResponseEntity.status(HttpStatus.OK).body(healthinsurance);
    }

}
