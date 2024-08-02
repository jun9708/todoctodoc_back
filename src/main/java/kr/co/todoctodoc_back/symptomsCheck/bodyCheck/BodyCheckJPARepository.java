package kr.co.todoctodoc_back.symptomsCheck.bodyCheck;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BodyCheckJPARepository extends JpaRepository<BodyCheck, Integer> {
    public Optional<BodyCheck> findByUserId(String userId);
}
