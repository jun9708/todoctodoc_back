package kr.co.todoctodoc_back.terms._dto;

import jakarta.persistence.Lob;
import lombok.*;

@Getter
@Setter
@Data
public class TermsRespDTO {

    //회원가입 약관 조회
    @Data
    public static class TermsDTO{

        private int termsNo;

        @Lob
        private String content1;
        @Lob
        private String content2;
        @Lob
        private String content3;

    }

}
