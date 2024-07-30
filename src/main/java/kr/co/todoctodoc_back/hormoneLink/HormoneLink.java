package kr.co.todoctodoc_back.hormoneLink;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class HormoneLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer hormoneLinkNo;

    @Column(length = 50, nullable = false)
    private String userId;

    @Column(length = 50, nullable = false)
    private String hormoneNo;

    @CreationTimestamp
    private Timestamp createdAt;

}
