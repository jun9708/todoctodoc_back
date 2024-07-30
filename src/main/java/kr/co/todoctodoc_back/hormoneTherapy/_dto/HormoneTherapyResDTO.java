package kr.co.todoctodoc_back.hormoneTherapy._dto;

import kr.co.todoctodoc_back.hormoneTherapy.HormoneTherapy;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class HormoneTherapyResDTO {

    @Data
    public static class therapyName{

        private int hormoneNo;
        private String therapyName;

    }


}