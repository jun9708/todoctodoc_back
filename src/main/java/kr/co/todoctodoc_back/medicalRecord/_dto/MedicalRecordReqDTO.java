package kr.co.todoctodoc_back.medicalRecord._dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import kr.co.todoctodoc_back.hormoneTherapy._dto.HormoneTherapyReqDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
public class MedicalRecordReqDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer medicalNo;

    private int userNo;

    private String userId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate diagnosisDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate surgeryDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate hormoneTherapyStartDate;

    private String hormoneTherapyName;

}
