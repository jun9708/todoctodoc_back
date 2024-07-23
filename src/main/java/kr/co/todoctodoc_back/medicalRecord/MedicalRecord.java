package kr.co.todoctodoc_back.medicalRecord;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hormoneNo;

    private LocalDate diagnosisDate;
    private LocalDate surgeryDate;
    private String hormoneTherapy;
    private LocalDate hormoneTherapyStartDate;

    @Builder
    public MedicalRecord(Long hormoneNo, LocalDate diagnosisDate, LocalDate surgeryDate, String hormoneTherapy, LocalDate hormoneTherapyStartDate) {
        this.hormoneNo = hormoneNo;
        this.diagnosisDate = diagnosisDate;
        this.surgeryDate = surgeryDate;
        this.hormoneTherapy = hormoneTherapy;
        this.hormoneTherapyStartDate = hormoneTherapyStartDate;


    }

}
