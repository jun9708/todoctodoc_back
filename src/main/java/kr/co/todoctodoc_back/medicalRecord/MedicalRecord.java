package kr.co.todoctodoc_back.medicalRecord;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "MedicalRecord")
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hormoneNo;
    private String hormoneTherapy;

    @CreationTimestamp
    private LocalDate injectionDate;
    @CreationTimestamp
    private LocalDate takeDate;

    @Builder
    public MedicalRecord(Long hormoneNo, String hormoneTherapy, LocalDate injectionDate, LocalDate takeDate) {
        this.hormoneNo = hormoneNo;


    }

}
