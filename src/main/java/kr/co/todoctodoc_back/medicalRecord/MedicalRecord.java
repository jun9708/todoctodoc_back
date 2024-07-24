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
    private Long id;

    private LocalDate diagnosisDate;
    private LocalDate surgeryDate;
    private String hormoneTherapy;
    private LocalDate hormoneTherapyStartDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicalRecord")
    private List<HormoneTherapy> hormoneTherapies;

    @Builder
    public MedicalRecord(Long hormoneNo, LocalDate diagnosisDate, LocalDate surgeryDate, String hormoneTherapy, LocalDate hormoneTherapyStartDate) {
        this.id = id;
        this.diagnosisDate = diagnosisDate;
        this.surgeryDate = surgeryDate;
        this.hormoneTherapy = hormoneTherapy;
        this.hormoneTherapyStartDate = hormoneTherapyStartDate;


    }

}
