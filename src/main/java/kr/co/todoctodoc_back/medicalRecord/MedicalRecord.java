package kr.co.todoctodoc_back.medicalRecord;

import jakarta.persistence.*;
import kr.co.todoctodoc_back.hormoneTherapy.HormoneTherapy;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer medicalNo;

    @Column(length = 50, nullable = false, unique = true)
    private String userId;

    private LocalDate diagnosisDate;
    private LocalDate surgeryDate;
    private LocalDate hormoneTherapyStartDate;

    @CreationTimestamp
    private Timestamp createdAt;

    @Builder
    public MedicalRecord(Integer medicalNo, String userId, LocalDate diagnosisDate, LocalDate surgeryDate, LocalDate hormoneTherapyStartDate, Timestamp createdAt) {
        this.medicalNo = medicalNo;
        this.userId = userId;
        this.diagnosisDate = diagnosisDate;
        this.surgeryDate = surgeryDate;
        this.hormoneTherapyStartDate = hormoneTherapyStartDate;
        this.createdAt = createdAt;


    }

}
