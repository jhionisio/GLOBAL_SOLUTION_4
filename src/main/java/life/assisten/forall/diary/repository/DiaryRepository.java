package life.assisten.forall.diary.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import life.assisten.forall.diary.domain.DiaryDomain;

public interface DiaryRepository extends JpaRepository<DiaryDomain, Integer> {

    Optional<DiaryDomain> findById(Integer id);

}
