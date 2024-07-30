package kr.co.todoctodoc_back.medicalRecord;

import jakarta.persistence.*;
import kr.co.todoctodoc_back.hormoneTherapy.HormoneTherapy;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer medicalNo;

    private String userId;

    private LocalDate diagnosisDate;
    private LocalDate surgeryDate;
    private LocalDate hormoneTherapyStartDate;
    private String hormoneTherapyNo;

    @Builder
    public MedicalRecord(Integer medicalNo, LocalDate diagnosisDate, LocalDate surgeryDate, String hormoneTherapyNo, LocalDate hormoneTherapyStartDate) {
        this.medicalNo = medicalNo;
        this.diagnosisDate = diagnosisDate;
        this.surgeryDate = surgeryDate;
        this.hormoneTherapyNo = hormoneTherapyNo;
        this.hormoneTherapyStartDate = hormoneTherapyStartDate;


    }

}
