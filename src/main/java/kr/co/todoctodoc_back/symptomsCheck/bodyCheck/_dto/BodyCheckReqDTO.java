package kr.co.todoctodoc_back.symptomsCheck.bodyCheck._dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Data
@Getter
@Setter
public class BodyCheckReqDTO {

    @Data
    public static class bodyCheckReqDTO{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer bodyCheckNo;

        private int userNo;
        private String userId;
        
        private Timestamp bodyCheckAlarm; //바디체크 알람 시간

        private int heatSensationScore; // 열감 점수
        private int cardiovascularScore; // 심혈관 점수
        private int sleepScore; // 수면 점수
        private int painScore; // 통증 점수

        @CreationTimestamp
        private Timestamp createdAt;

    }


}
