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

    private int userNo;

    @Column(length = 50, nullable = false, unique = true)
    private String userId;

    private LocalDate diagnosisDate;
    private LocalDate surgeryDate;
    private LocalDate hormoneTherapyStartDate;

    private String hormoneTherapyName;

    @CreationTimestamp
    private Timestamp createdAt;

    @Builder
    public MedicalRecord(Integer medicalNo, int userNo, String userId, LocalDate diagnosisDate, LocalDate surgeryDate, LocalDate hormoneTherapyStartDate, String hormoneTherapyName, Timestamp createdAt) {
        this.medicalNo = medicalNo;
        this.userNo = userNo;
        this.userId = userId;
        this.diagnosisDate = diagnosisDate;
        this.surgeryDate = surgeryDate;
        this.hormoneTherapyStartDate = hormoneTherapyStartDate;
        this.hormoneTherapyName = hormoneTherapyName;
        this.createdAt = createdAt;


    }

}
