package life.assisten.forall.record.useCases;

import life.assisten.forall.record.controller.converter.RecordToDTO;
import life.assisten.forall.record.controller.dto.RecordDTO;
import life.assisten.forall.record.domain.RecordDomain;
import life.assisten.forall.record.repository.RecordRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class RecordList {

    private final RecordRepository recordRepository;
    private final RecordToDTO converter;

    public RecordList(RecordRepository recordRepository, RecordToDTO converter) {
        this.recordRepository = recordRepository;
        this.converter = converter;
    }

    public List<RecordDTO> listRecords() {
        List<RecordDomain> recordDomains = recordRepository.findAll();
        return recordDomains.stream()
                .map(converter::convertToDTO)
                .collect(Collectors.toList());
    }

    public RecordDTO findRecordById(Integer idFicha) {
        Optional<RecordDomain> optionalRecordDomain = recordRepository.findById(idFicha);
        return optionalRecordDomain.map(converter::convertToDTO)orElse(null);
    }
}
