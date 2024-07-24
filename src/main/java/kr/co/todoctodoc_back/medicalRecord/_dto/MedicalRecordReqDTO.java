package kr.co.todoctodoc_back.medicalRecord._dto;

import kr.co.todoctodoc_back.hormoneTherapy._dto.HormoneTherapyReqDTO;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Data
@Getter
@Setter
public class MedicalRecordReqDTO {

    private LocalDate diagnosisDate;
    private LocalDate surgeryDate;
    private List<HormoneTherapyReqDTO> hormoneTherapies;
    private LocalDate hormoneTherapyStartDate;


}
