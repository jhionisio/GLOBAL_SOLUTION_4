package life.assisten.forall.record.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import life.assisten.forall.record.controller.dto.RecordDTO;
import life.assisten.forall.record.useCases.RecordCreate;
import life.assisten.forall.record.useCases.RecordList;

@RestController
@RequestMapping("/record")
public class RecordController {

    private final RecordCreate recordCreate;
    private final RecordList recordList;

    public RecordController(RecordCreate recordCreate, RecordList recordList) {
        this.recordCreate = recordCreate;
        this.recordList = recordList;
    }

    @PostMapping
    public ResponseEntity<?> createRecord(@Valid @RequestBody RecordDTO dto){
        recordCreate.createRecord(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<RecordDTO>> listRecords(){
        List<RecordDTO> records = recordList.listRecords();
        return ResponseEntity.status(HttpStatus.OK).body(records);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecordDTO> findrecordById(@PathVariable Integer id) {
        RecordDTO record = recordList.findRecordById(id);
        return ResponseEntity.status(HttpStatus.OK).body(record);
    }
    
}
