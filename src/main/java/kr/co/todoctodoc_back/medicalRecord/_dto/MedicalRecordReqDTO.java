package kr.co.todoctodoc_back.medicalRecord._dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
public class MedicalRecordReqDTO {

    private LocalDate diagnosisDate;
    private LocalDate surgeryDate;
    private String hormoneTherapy;
    private LocalDate hormoneTherapyStartDate;


}
