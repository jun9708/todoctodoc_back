package kr.co.todoctodoc_back.medicalRecord;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicalRecordJPARepository extends JpaRepository<MedicalRecord, Integer> {

    public Optional<MedicalRecord> findByUserId(String userId);


}
