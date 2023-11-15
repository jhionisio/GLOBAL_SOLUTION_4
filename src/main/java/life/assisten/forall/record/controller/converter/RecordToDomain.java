package life.assisten.forall.record.controller.converter;

import life.assisten.forall.record.controller.dto.RecordDTO;
import life.assisten.forall.record.domain.RecordDomain;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class RecordToDomain {
    private final ModelMapper modelMapper;

    public RecordDomain convertToDomain(RecordDTO dto) {
        return modelMapper.map(dto, RecordDomain.class);
    }
}
