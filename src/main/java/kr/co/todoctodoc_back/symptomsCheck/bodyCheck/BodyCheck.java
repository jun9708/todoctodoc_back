package kr.co.todoctodoc_back.symptomsCheck.bodyCheck;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class BodyCheck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bodyCheckNo;
    private String userId;
    private String score;
    private LocalTime alarm;

}
