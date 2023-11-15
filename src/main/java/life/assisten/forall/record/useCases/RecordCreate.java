package life.assisten.forall.record.useCases;

import org.springframework.stereotype.Service;

import life.assisten.forall.record.controller.converters.RecordToDomain;
import life.assisten.forall.record.controller.dto.RecordDTO;
import life.assisten.forall.record.domain.RecordDomain;
import life.assisten.forall.record.repository.RecordRepository;

@Service
public class RecordCreate {

    private final RecordRepository recordRepository;
    private final RecordToDomain converter;

    public RecordCreate(RecordRepository recordRepository, RecordToDomain converter) {
        this.recordRepository = recordRepository;
        this.converter = converter;
    }

    public RecordDomain createRecord(RecordDTO recordDTO) {
        RecordDomain recordDomain = converter.convertToDomain(recordDTO);
        return recordRepository.save(recordDomain);
    }
}
