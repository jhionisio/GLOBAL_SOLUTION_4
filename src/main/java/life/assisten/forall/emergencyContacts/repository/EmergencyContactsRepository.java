package life.assisten.forall.emergencyContacts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import life.assisten.forall.emergencyContacts.domain.EmergencyContactsDomain;

import java.util.Optional;

public interface EmergencyContactsRepository extends JpaRepository<EmergencyContactsDomain, Integer> {

    Optional<EmergencyContactsDomain> findByIdContatos(Integer idContatos);

}
