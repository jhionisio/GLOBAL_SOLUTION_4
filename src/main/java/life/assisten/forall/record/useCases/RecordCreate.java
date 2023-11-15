package life.assisten.forall.record.useCases;

import life.assisten.forall.record.controller.converter.RecordToDomain;
import life.assisten.forall.record.controller.dto.RecordDTO;
import life.assisten.forall.record.domain.RecordDomain;
import life.assisten.forall.record.repository.RecordRepository;

public class RecordCreate {

    private final RecordRepository recordRepository;
    private final RecordToDomain converter;

    public RecordCreate(RecordRepository recordRepository, RecordToDomain converter) {
        this.recordRepository = recordRepository;
        this.converter = converter;
    }

    public RecordDomain createRecord(RecordDTO RecordDTO) {
        RecordDomain RecordDomain = converter.convertToDomain(RecordDTO);
        return recordRepository.save(RecordDomain);
    }
}