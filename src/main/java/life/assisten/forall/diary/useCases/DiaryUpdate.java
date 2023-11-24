package life.assisten.forall.diary.useCases;

import life.assisten.forall.diary.controller.dto.DiaryDTO;
import life.assisten.forall.diary.controller.converter.DiaryToDTO;
import life.assisten.forall.diary.controller.converter.DiaryToDomain;
import life.assisten.forall.diary.domain.DiaryDomain;
import life.assisten.forall.diary.repository.DiaryRepository;
import org.springframework.stereotype.Service;

@Service
public class DiaryUpdate {

    private final DiaryRepository diaryRepository;
    private final DiaryToDomain converter;
    private final DiaryToDTO dtoConverter;

    public DiaryUpdate(DiaryRepository diaryRepository, DiaryToDomain converter, DiaryToDTO dtoConverter) {
        this.diaryRepository = diaryRepository;
        this.converter = converter;
        this.dtoConverter = dtoConverter;
    }

    public DiaryDTO updateDiaryById(Integer diaryId, DiaryDTO updatedDiaryDTO) {
        if (diaryRepository.existsById(diaryId)) {
            DiaryDomain existingDiary = diaryRepository.findById(diaryId).orElse(null);

            if (existingDiary != null) {
                DiaryDomain updatedDiary = converter.convertToDomain(updatedDiaryDTO);
                updatedDiary.setIdAgenda(existingDiary.getIdAgenda());
                DiaryDomain savedDiary = diaryRepository.save(updatedDiary);
                return dtoConverter.convertToDTO(savedDiary);
            }
        }
        return null;
    }
}
