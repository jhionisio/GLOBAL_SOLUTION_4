package life.assisten.forall.diary.controller;

import life.assisten.forall.diary.controller.dto.DiaryDTO;
import life.assisten.forall.diary.useCases.DiaryCreate;
import life.assisten.forall.diary.useCases.DiaryDelete;
import life.assisten.forall.diary.useCases.DiaryList;
import life.assisten.forall.diary.useCases.DiaryUpdate;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/diary")
public class DiaryController {

    private final DiaryCreate diaryCreate;
    private final DiaryList diaryList;
    private final DiaryDelete diaryDelete;
    private final DiaryUpdate diaryUpdate;

    public DiaryController(DiaryCreate diaryCreate, DiaryList diaryList, DiaryDelete diaryDelete,
            DiaryUpdate diaryUpdate) {
        this.diaryCreate = diaryCreate;
        this.diaryList = diaryList;
        this.diaryDelete = diaryDelete;
        this.diaryUpdate = diaryUpdate;
    }

    @PostMapping
    public ResponseEntity<?> createDiary(@Valid @RequestBody DiaryDTO dto) {
        diaryCreate.createDiary(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<DiaryDTO>> listDiaries() {
        List<DiaryDTO> diaries = diaryList.listDiaries();
        return ResponseEntity.status(HttpStatus.OK).body(diaries);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DiaryDTO> findDiaryById(@PathVariable Integer id) {
        DiaryDTO diary = diaryList.findDiaryById(id);
        return ResponseEntity.status(HttpStatus.OK).body(diary);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDiary(@PathVariable Integer id) {
        diaryDelete.deleteDiaryById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DiaryDTO> updateDiary(@PathVariable Integer id,
            @Valid @RequestBody DiaryDTO updatedDiaryDTO) {
        DiaryDTO updatedDiary = diaryUpdate.updateDiaryById(id, updatedDiaryDTO);
        if (updatedDiary != null) {
            return ResponseEntity.status(HttpStatus.OK).body(updatedDiary);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
