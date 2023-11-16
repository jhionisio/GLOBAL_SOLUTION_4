package life.assisten.forall.record.useCases;

import org.springframework.stereotype.Service;

import life.assisten.forall.record.controller.converters.RecordToDTO;
import life.assisten.forall.record.controller.dto.RecordDTO;
import life.assisten.forall.record.domain.RecordDomain;
import life.assisten.forall.record.repository.RecordRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecordList {

    private final RecordRepository recordRepository;
    private final RecordToDTO converter;

    public RecordList(RecordRepository recordRepository, RecordToDTO converter) {
        this.recordRepository = recordRepository;
        this.converter = converter;
    }

    public List<RecordDTO> listRecords() {
        List<RecordDomain> doctorDomains = recordRepository.findAll();
        return doctorDomains.stream()
                .map(converter::convertToDTO)
                .collect(Collectors.toList());
    }

    public RecordDTO findRecordById(Integer idRecord) {
        Optional<RecordDomain> optionalDoctorDomain = recordRepository.findById(idRecord);
        return optionalDoctorDomain.map(converter::convertToDTO).orElse(null);
    }

}
