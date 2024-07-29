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

    @OneToMany(mappedBy = "medical_record_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HormoneTherapy> hormoneTherapy;

    @Builder
    public MedicalRecord(Integer medicalNo, LocalDate diagnosisDate, LocalDate surgeryDate, List<HormoneTherapy> hormoneTherapy, LocalDate hormoneTherapyStartDate) {
        this.medicalNo = medicalNo;
        this.diagnosisDate = diagnosisDate;
        this.surgeryDate = surgeryDate;
        this.hormoneTherapy = hormoneTherapy;
        this.hormoneTherapyStartDate = hormoneTherapyStartDate;


    }

}
