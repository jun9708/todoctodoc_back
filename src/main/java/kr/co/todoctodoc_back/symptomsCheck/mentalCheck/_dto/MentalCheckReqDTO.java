package kr.co.todoctodoc_back.symptomsCheck.mentalCheck._dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Data
public class MentalCheckReqDTO {

    @Data
    public static class mentalCheckReqDTO{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer mentalCheckNo;

        private int userNo;
        private String userId;

        private Timestamp mentalCheckAlarm; //정신체크 알람 시간

        private int mentalScore1; // 정신 점수 1
        private int mentalScore2; // 정신 점수 2
        private int mentalScore3; // 정신 점수 3

        @CreationTimestamp
        private Timestamp createdAt;

    }

}
