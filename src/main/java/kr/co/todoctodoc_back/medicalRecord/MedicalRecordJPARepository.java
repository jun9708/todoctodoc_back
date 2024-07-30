package kr.co.todoctodoc_back.medicalRecord;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalRecordJPARepository extends JpaRepository<MedicalRecord, Integer> {
}
