package life.assisten.forall.diary.controller;

import life.assisten.forall.diary.controller.dto.DiaryDTO;
import life.assisten.forall.diary.useCases.DiaryCreate;
import life.assisten.forall.diary.useCases.DiaryList;
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

    public DiaryController(DiaryCreate diaryCreate, DiaryList diaryList) {
        this.diaryCreate = diaryCreate;
        this.diaryList = diaryList;
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
}
