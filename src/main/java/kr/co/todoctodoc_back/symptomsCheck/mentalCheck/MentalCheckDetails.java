package kr.co.todoctodoc_back.symptomsCheck.mentalCheck;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class MentalCheckDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mentalCheckDetailsNo;

    @Column(length = 50, nullable = false)
    private String userId;





    @CreationTimestamp
    private Timestamp createdAt;

}
