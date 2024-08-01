package kr.co.todoctodoc_back.symptomsCheck.mentalCheck;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class MentalCheck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mentalCheckNo;
    private int userNo;
    private String userId;
    private int score;

    @CreationTimestamp
    private Timestamp mentalCheckAlarm;
    @CreationTimestamp
    private Timestamp createdAt;

    @Builder
    public MentalCheck(int mentalCheckNo, int userNo, String userId, int score, Timestamp mentalCheckAlarm, Timestamp createdAt){
        this.mentalCheckNo = mentalCheckNo;
        this.userNo = userNo;
        this.userId = userId;
        this.score = score;
        this.mentalCheckAlarm = mentalCheckAlarm;
        this.createdAt = createdAt;
    }

}
