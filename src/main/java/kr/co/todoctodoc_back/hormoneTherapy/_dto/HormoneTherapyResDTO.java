package kr.co.todoctodoc_back.hormoneTherapy._dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class HormoneTherapyResDTO {
    private Long hormoneNo;
    private String name;

    public HormoneTherapyResDTO(Long hormoneNo, String name) {
        this.hormoneNo = hormoneNo;
        this.name = name;
    }

    // 생성자, getter, setter 등 Lombok이 자동으로 생성
}