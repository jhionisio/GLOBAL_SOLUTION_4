package life.assisten.forall.doctor.repository;

import life.assisten.forall.doctor.domain.DoctorDomain;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<DoctorDomain, Integer> {

    Optional<DoctorDomain> findById(Integer idMedico);

}
