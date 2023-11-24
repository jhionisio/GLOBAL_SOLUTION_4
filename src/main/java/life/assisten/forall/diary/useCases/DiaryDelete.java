package life.assisten.forall.diary.useCases;

import life.assisten.forall.diary.repository.DiaryRepository;
import org.springframework.stereotype.Service;

@Service
public class DiaryDelete {

    private final DiaryRepository diaryRepository;

    public DiaryDelete(DiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }

    public void deleteDiaryById(Integer diaryId) {
        if (diaryRepository.existsById(diaryId)) {
            diaryRepository.deleteById(diaryId);
        }
    }
}