package kr.co.todoctodoc_back.user;

import jakarta.persistence.*;
import kr.co.todoctodoc_back._core.utils.TimestampUtils;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "user_tb")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userNo;

    @Column(length = 50, nullable = false, unique = true)
    private String userId;

    @Column(length = 50, nullable = false)
    private String username;

    @Column(nullable = false)
    private String birth;

    @Column(length = 50, nullable = false)
    private String tel;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 50)
    private String nickname;

    private boolean role; // user = true | admin = false

    @CreationTimestamp
    private Timestamp userCreatedAt;

    @Builder
    public User( Integer userNo, String userId, String username, String birth, String tel, String password, String nickname, boolean role, Timestamp userCreatedAt) {
        this.userNo = userNo;
        this.userId = userId;
        this.username = username;
        this.birth = birth;
        this.tel = tel;
        this.password = password;
        this.nickname = nickname;
        this.role = role;
        this.userCreatedAt = userCreatedAt;
    }

    public void updateNickname(String nickname){
        this.nickname = nickname;
    }

    public void updatePassword(String password){
        this.password = password;
    }

    public String formatCreateAt(){
        return TimestampUtils.timeStampToDate(userCreatedAt);
    }

}