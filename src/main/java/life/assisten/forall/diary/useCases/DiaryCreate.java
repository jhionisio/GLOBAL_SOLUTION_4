package life.assisten.forall.diary.useCases;

import life.assisten.forall.diary.controller.dto.DiaryDTO;
import life.assisten.forall.diary.controller.converter.DiaryToDomain;
import life.assisten.forall.diary.domain.DiaryDomain;
import life.assisten.forall.diary.repository.DiaryRepository;
import org.springframework.stereotype.Service;

@Service
public class DiaryCreate {

    private final DiaryRepository diaryRepository;
    private final DiaryToDomain converter;

    public DiaryCreate(DiaryRepository diaryRepository, DiaryToDomain converter) {
        this.diaryRepository = diaryRepository;
        this.converter = converter;
    }

    public DiaryDomain createDiary(DiaryDTO diaryDTO) {
        DiaryDomain diaryDomain = converter.convertToDomain(diaryDTO);
        return diaryRepository.save(diaryDomain);
    }
}
