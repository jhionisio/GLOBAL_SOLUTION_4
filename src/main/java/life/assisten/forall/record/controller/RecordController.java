package life.assisten.forall.record.controller;

import life.assisten.forall.record.controller.dto.RecordDTO;
import life.assisten.forall.record.useCases.RecordCreate;
import life.assisten.forall.record.useCases.RecordList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<?> createRecord(@RequestBody RecordDTO dto) {
        recordCreate.createRecord(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<RecordDTO>> listRecords() {
        List<RecordDTO> records = recordList.listRecords();
        return ResponseEntity.status(HttpStatus.OK).body(records);
    }

}
