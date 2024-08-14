package kr.co.todoctodoc_back.symptomsCheck.bodyCheck;

import kr.co.todoctodoc_back.symptomsCheck.bodyCheck._details.BodyCheckDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Repository
public interface BodyCheckJPARepository extends JpaRepository<BodyCheck, Integer> {
    public Optional<BodyCheck> findByUserId(String userId);
    public Optional<Timestamp> findBodyCheckAlarmByUserId(String userId);
}
