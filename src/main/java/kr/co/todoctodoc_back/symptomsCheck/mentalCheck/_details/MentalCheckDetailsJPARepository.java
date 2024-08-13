package kr.co.todoctodoc_back.symptomsCheck.mentalCheck._details;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MentalCheckDetailsJPARepository extends JpaRepository<MentalCheckDetails, Integer> {
    List<MentalCheckDetails> findByUserNoAndCreatedAtBetween(int userNo, Date startDate, Date endDate);
}
