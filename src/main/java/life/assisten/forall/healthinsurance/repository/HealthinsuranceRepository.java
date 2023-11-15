package life.assisten.forall.healthinsurance.repository;

import life.assisten.forall.healthinsurance.domain.HealthinsuranceDomain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HealthinsuranceRepository extends JpaRepository<HealthinsuranceDomain, Integer> {

    Optional<HealthinsuranceDomain> findById(Integer idPlano);

}
