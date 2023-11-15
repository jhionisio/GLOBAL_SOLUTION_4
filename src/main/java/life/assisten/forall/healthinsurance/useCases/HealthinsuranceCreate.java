package life.assisten.forall.healthinsurance.useCases;

import org.springframework.stereotype.Service;

import life.assisten.forall.healthinsurance.controller.converter.HealthinsuranceToDomain;
import life.assisten.forall.healthinsurance.controller.dto.HealthinsuranceDTO;
import life.assisten.forall.healthinsurance.domain.HealthinsuranceDomain;
import life.assisten.forall.healthinsurance.repository.HealthinsuranceRepository;

@Service
public class HealthinsuranceCreate {

    private final HealthinsuranceRepository healthInsuranceRepository;
    private final HealthinsuranceToDomain converter;

    public HealthinsuranceCreate(HealthinsuranceRepository healthInsuranceRepository, HealthinsuranceToDomain converter) {
        this.healthInsuranceRepository = healthInsuranceRepository;
        this.converter = converter;
    }

    public HealthinsuranceDomain createHealthInsurance(HealthinsuranceDTO healthInsuranceDTO) {
        HealthinsuranceDomain healthInsuranceDomain = converter.convertToDomain(healthInsuranceDTO);
        return healthInsuranceRepository.save(healthInsuranceDomain);
    }
}