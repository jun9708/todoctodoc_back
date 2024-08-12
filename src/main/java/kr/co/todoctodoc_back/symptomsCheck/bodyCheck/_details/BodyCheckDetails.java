package kr.co.todoctodoc_back.symptomsCheck.bodyCheck._details;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class BodyCheckDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bodyCheckDetailsNo;

    private int userNo;

    @Column(length = 50, nullable = false)
    private String userId;

    @Column(nullable = false)
    private int heatSensationScore; // 열감 점수

    @Column(nullable = false)
    private int cardiovascularScore; // 심혈관 점수

    @Column(nullable = false)
    private int sleepScore; // 수면 점수

    @Column(nullable = false)
    private int painScore; // 통증 점수

    @CreationTimestamp
    private Timestamp createdAt;

    @Builder
    public BodyCheckDetails(Integer bodyCheckDetailsNo, int userNo, String userId, int heatSensationScore, int cardiovascularScore, int sleepScore, int painScore, Timestamp createdAt){
        this.bodyCheckDetailsNo = bodyCheckDetailsNo;
        this.userNo = userNo;
        this.userId = userId;
        this.heatSensationScore = heatSensationScore;
        this.cardiovascularScore = cardiovascularScore;
        this.sleepScore = sleepScore;
        this.painScore = painScore;
        this.createdAt = createdAt;
    }

}
