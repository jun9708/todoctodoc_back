package kr.co.todoctodoc_back.hormoneTherapy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HormoneTherapyJPARepository extends JpaRepository<HormoneTherapy, Integer> {
}
