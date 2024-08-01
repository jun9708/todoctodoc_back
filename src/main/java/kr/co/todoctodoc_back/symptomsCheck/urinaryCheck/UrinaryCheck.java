package kr.co.todoctodoc_back.symptomsCheck.urinaryCheck;

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
public class UrinaryCheck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int urinaryCheckNo;
    private int userNo;
    private String userId;
    private int score;

    @CreationTimestamp
    private Timestamp urinaryCheckAlarm;
    @CreationTimestamp
    private Timestamp createdAt;

    @Builder
    public UrinaryCheck(int urinaryCheckNo, int userNo, String userId, int score, Timestamp urinaryCheckAlarm, Timestamp createdAt){
        this.urinaryCheckNo = urinaryCheckNo;
        this.userNo = userNo;
        this.userId = userId;
        this.score = score;
        this.urinaryCheckAlarm = urinaryCheckAlarm;
        this.createdAt = createdAt;
    }

}
