package kr.co.todoctodoc_back.symptomsCheck.bodyCheck._details;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BodyCheckDetailsJPARepository extends JpaRepository<BodyCheckDetails, Integer> {


}
