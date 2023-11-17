package life.assisten.forall.doctor_patient.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import life.assisten.forall.doctor_patient.domain.DoctorPatientDomain;

@Repository
public interface DoctorPatientRepository extends JpaRepository<DoctorPatientDomain, Integer> {

    Optional<DoctorPatientDomain> findById(Integer idRecord);

}
