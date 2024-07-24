package kr.co.todoctodoc_back.medicalRecord._dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate diagnosisDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate surgeryDate;

    private List<String> hormoneTherapies = new ArrayList<>();

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate hormoneTherapyStartDate;


}
