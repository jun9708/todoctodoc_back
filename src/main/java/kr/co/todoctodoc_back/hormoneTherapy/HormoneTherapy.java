package kr.co.todoctodoc_back.hormoneTherapy;

import jakarta.persistence.*;
import kr.co.todoctodoc_back.medicalRecord.MedicalRecord;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
@Entity
public class HormoneTherapy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hormone_id;

    @ManyToOne
    @JoinColumn(name = "medical_record_id")
    private MedicalRecord medicalRecord;

    private String name;





}
