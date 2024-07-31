package kr.co.todoctodoc_back.hormoneTherapy;

import jakarta.persistence.*;
import kr.co.todoctodoc_back.medicalRecord.MedicalRecord;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HormoneTherapy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hormoneTherapyNo;

    @Column(length = 50, nullable = false, unique = true)
    private String therapyName;

}
