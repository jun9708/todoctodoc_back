package kr.co.todoctodoc_back.symptomsCheck.bodyCheck._details;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface BodyCheckDetailsJPARepository extends JpaRepository<BodyCheckDetails, Integer> {

    public List<BodyCheckDetails> findByUserNoAndCreatedAt(int userNo, Timestamp createAt);

    List<BodyCheckDetails> findByUserNoAndCreatedAtBetween(int userNo, Date startDate, Date endDate);

}
