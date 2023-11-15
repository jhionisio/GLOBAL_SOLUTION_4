package life.assisten.forall.diary.useCases;

import life.assisten.forall.diary.controller.converter.DiaryToDTO;
import life.assisten.forall.diary.controller.dto.DiaryDTO;
import life.assisten.forall.diary.domain.DiaryDomain;
import life.assisten.forall.diary.repository.DiaryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DiaryList {

    private final DiaryRepository diaryRepository;
    private final DiaryToDTO converter;

    public DiaryList(DiaryRepository diaryRepository, DiaryToDTO converter) {
        this.diaryRepository = diaryRepository;
        this.converter = converter;
    }

    public List<DiaryDTO> listDiaries() {
        List<DiaryDomain> diaryDomains = diaryRepository.findAll();
        return diaryDomains.stream()
                .map(converter::convertToDTO)
                .collect(Collectors.toList());
    }

    public DiaryDTO findDiaryById(Integer id) {
        Optional<DiaryDomain> optionalDiaryDomain = diaryRepository.findById(id);
        return optionalDiaryDomain.map(converter::convertToDTO).orElse(null);
    }
}
