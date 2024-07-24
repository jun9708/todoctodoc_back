package kr.co.todoctodoc_back.hormoneTherapy._dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class HormoneTherapyResDTO {
    private Long id;
    private String name;

    public HormoneTherapyResDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // 생성자, getter, setter 등 Lombok이 자동으로 생성
}