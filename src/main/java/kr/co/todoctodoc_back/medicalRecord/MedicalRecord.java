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

    private Integer userNo;

    @Column(length = 50, nullable = false, unique = true)
    private String userId;


    private String diagnosisDate;
    private String surgeryDate;
    private String hormoneTherapyStartDate;
    private String injectionStartDate;

    private String hormoneTherapyName;

    @CreationTimestamp
    private Timestamp createdAt;

    @Builder
    public MedicalRecord(Integer medicalNo, int userNo, String userId, String diagnosisDate, String surgeryDate, String hormoneTherapyStartDate, String injectionStartDate,String hormoneTherapyName, Timestamp createdAt) {
        this.medicalNo = medicalNo;
        this.userNo = userNo;
        this.userId = userId;
        this.diagnosisDate = diagnosisDate;
        this.surgeryDate = surgeryDate;
        this.hormoneTherapyStartDate = hormoneTherapyStartDate;
        this.injectionStartDate = injectionStartDate;
        this.hormoneTherapyName = hormoneTherapyName;
        this.createdAt = createdAt;


    }

}
