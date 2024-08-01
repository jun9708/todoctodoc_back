package kr.co.todoctodoc_back.symptomsCheck.urinaryCheck;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class UrinaryCheckDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer urinaryCheckDetailsNo;

    @Column(length = 50, nullable = false)
    private String userId;




    @CreationTimestamp
    private Timestamp createdAt;

}
