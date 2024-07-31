package kr.co.todoctodoc_back.hormoneLink;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HormoneLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hormoneLinkNo;

    @Column(length = 50, nullable = false)
    private String userId;

    @Column(length = 50, nullable = false)
    private int hormoneTherapyNo;

    @CreationTimestamp
    private Timestamp createdAt;

}
