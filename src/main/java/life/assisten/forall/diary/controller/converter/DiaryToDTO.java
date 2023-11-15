package life.assisten.forall.diary.controller.converter;

import life.assisten.forall.diary.controller.dto.DiaryDTO;
import life.assisten.forall.diary.domain.DiaryDomain;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DiaryToDTO {

    private final ModelMapper modelMapper;

    public DiaryDTO convertToDTO(DiaryDomain domain) {
        return modelMapper.map(domain, DiaryDTO.class);
    }
}
