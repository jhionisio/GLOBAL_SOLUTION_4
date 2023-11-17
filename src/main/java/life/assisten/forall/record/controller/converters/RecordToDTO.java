package life.assisten.forall.record.controller.converters;

import life.assisten.forall.record.controller.dto.RecordDTO;
import life.assisten.forall.record.domain.RecordDomain;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class RecordToDTO {

    private final ModelMapper modelMapper;

    public RecordDTO convertToDTO(RecordDomain domain) {
        return modelMapper.map(domain, RecordDTO.class);
    }
}
