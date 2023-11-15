package life.assisten.forall.record.controller.converters;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import life.assisten.forall.record.controller.dto.RecordDTO;
import life.assisten.forall.record.domain.RecordDomain;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class RecordToDomain {
    private final ModelMapper modelMapper;

    public RecordDomain convertToDomain(RecordDTO recordDTO) {
        return modelMapper.map(recordDTO, RecordDomain.class);
    }
}
