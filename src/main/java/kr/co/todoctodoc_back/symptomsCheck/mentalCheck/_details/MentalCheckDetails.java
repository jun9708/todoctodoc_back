package kr.co.todoctodoc_back.symptomsCheck.mentalCheck._details;

import jakarta.persistence.*;
import kr.co.todoctodoc_back.symptomsCheck.mentalCheck.MentalCheck;
import lombok.AccessLevel;
import lombok.Builder;
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

    private int userNo;

    @Column(length = 50, nullable = false)
    private String userId;

    @Column(nullable = false)
    private int mentalScore1; // 정신적 검사 1

    @Column(nullable = false)
    private int mentalScore2; // 정신적 검사 2

    @Column(nullable = false)
    private int mentalScore3; // 정신적 검사 3

    @CreationTimestamp
    private Timestamp createdAt;

    @Builder
    public MentalCheckDetails(Integer MentalCheckDetailsNo, int userNo, String userId, int mentalScore1, int mentalScore2, int mentalScore3, Timestamp createdAt){
        this.mentalCheckDetailsNo = getMentalCheckDetailsNo();
        this.userNo = userNo;
        this.userId = userId;
        this.mentalScore1 = mentalScore1;
        this.mentalScore2 = mentalScore2;
        this.mentalScore3 = mentalScore3;
        this.createdAt = createdAt;
    }


}
