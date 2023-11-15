package life.assisten.forall.patient.repository;

import life.assisten.forall.patient.domain.PatientDomain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepository extends JpaRepository<PatientDomain, Integer> {

    Optional<PatientDomain> findByIdPaciente(Integer idPaciente);

    Optional<PatientDomain> findByEmail(String nnEmail);
}
