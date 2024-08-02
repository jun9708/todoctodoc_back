package kr.co.todoctodoc_back.symptomsCheck.bodyCheck;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalTime;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class BodyCheck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bodyCheckNo;
    private int userNo;
    private String userId;

    private int bodyCheckDetailsNo;

    @CreationTimestamp
    private Timestamp bodyCheckAlarm;
    @CreationTimestamp
    private Timestamp createdAt;

    @Builder
    public BodyCheck(int bodyCheckNo, int userNo, String userId,int bodyCheckDetailsNo, Timestamp bodyCheckAlarm, Timestamp createdAt){
        this.bodyCheckNo = bodyCheckNo;
        this.userNo = userNo;
        this.userId = userId;
        this.bodyCheckDetailsNo = bodyCheckDetailsNo;
        this.bodyCheckAlarm = bodyCheckAlarm;
        this.createdAt = createdAt;
    }

}
