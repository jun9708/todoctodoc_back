package kr.co.todoctodoc_back.hormoneTherapy._dto;

import kr.co.todoctodoc_back.hormoneTherapy.HormoneTherapy;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class HormoneTherapyReqDTO {

    @Data
    public static class horemoneListReqDTO{

        List<HormoneTherapy> hormoneTherapyList;

    }

    // 생성자, getter, setter 등 Lombok이 자동으로 생성
}