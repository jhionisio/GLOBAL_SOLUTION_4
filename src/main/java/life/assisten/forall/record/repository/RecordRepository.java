package life.assisten.forall.record.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import life.assisten.forall.record.domain.RecordDomain;

public interface RecordRepository extends JpaRepository<RecordDomain, Integer>{

    Optional<RecordDomain> findById(Integer idFicha);
    
} 