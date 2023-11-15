package life.assisten.forall.healthinsurance.useCases;

import life.assisten.forall.healthinsurance.controller.converter.HealthinsuranceToDTO;
import life.assisten.forall.healthinsurance.controller.dto.HealthinsuranceDTO;
import life.assisten.forall.healthinsurance.domain.HealthinsuranceDomain;
import life.assisten.forall.healthinsurance.repository.HealthinsuranceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HealthinsuranceList {

    private final HealthinsuranceRepository healthinsuranceRepository;
    private final HealthinsuranceToDTO converter;

    public HealthinsuranceList(HealthinsuranceRepository healthinsuranceRepository, HealthinsuranceToDTO converter) {
        this.healthinsuranceRepository = healthinsuranceRepository;
        this.converter = converter;
    }

    public List<HealthinsuranceDTO> listHealthinsurances() {
        List<HealthinsuranceDomain> healthinsuranceDomains = healthinsuranceRepository.findAll();
        return healthinsuranceDomains.stream()
                .map(converter::convertToDTO)
                .collect(Collectors.toList());
    }

    public HealthinsuranceDTO findHealthinsuranceById(Integer id) {
        Optional<HealthinsuranceDomain> optionalHealthinsuranceDomain = healthinsuranceRepository.findById(id);
        return optionalHealthinsuranceDomain.map(converter::convertToDTO).orElse(null);
    }
}
