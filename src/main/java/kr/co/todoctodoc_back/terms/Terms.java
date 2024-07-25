package kr.co.todoctodoc_back.terms;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Terms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer termsNo;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String content1;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String content2;

    @Lob
    @Column(columnDefinition = "LONGTEXT")
    private String content3;

    @Builder
    public Terms(Integer termsNo, String content1, String content2, String content3){
        this.termsNo = termsNo;
        this.content1 = content1;
        this.content2 = content2;
        this.content3 = content3;
    }
}
