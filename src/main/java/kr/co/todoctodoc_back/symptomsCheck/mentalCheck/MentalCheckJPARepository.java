package kr.co.todoctodoc_back.symptomsCheck.mentalCheck;

import kr.co.todoctodoc_back.symptomsCheck.mentalCheck._details.MentalCheckDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface MentalCheckJPARepository extends JpaRepository<MentalCheck, Integer> {
    public Optional<MentalCheck> findByUserId(String userId);

}
