package kr.co.todoctodoc_back.hormoneTherapy._dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class HormoneTherapyReqDTO {
    private String name;

    // 생성자, getter, setter 등 Lombok이 자동으로 생성
}