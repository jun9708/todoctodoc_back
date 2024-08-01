package kr.co.todoctodoc_back.hormoneLink;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor
@Entity
public class HormoneLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hormoneLinkNo;

    @Column(length = 50, nullable = false)
    private int userNo;

    @Column(length = 50, nullable = false)
    private int hormoneTherapyNo;

    @CreationTimestamp
    private Timestamp createdAt;

    @Builder
    public HormoneLink(Integer hormoneLinkNo, int userNo, int hormoneTherapyNo,Timestamp createdAt){
        this.hormoneLinkNo = hormoneLinkNo;
        this.userNo = userNo;
        this.hormoneTherapyNo = hormoneTherapyNo;
        this.createdAt = createdAt;
    }

}
