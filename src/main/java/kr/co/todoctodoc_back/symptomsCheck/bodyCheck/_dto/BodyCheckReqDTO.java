package kr.co.todoctodoc_back.symptomsCheck.bodyCheck._dto;

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

    public static class bodyCheckReqDTO{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer BodyCheckNo;

        private int userNo;

        private int totalScore; //총합

        private Timestamp bodyCheckAlarm;

        @CreationTimestamp
        private Timestamp createdAt;

    }



}
