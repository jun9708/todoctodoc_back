package kr.co.todoctodoc_back.user;

import jakarta.persistence.*;
import kr.co.todoctodoc_back._core.utils.TimestampUtils;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "user_tb")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userNo;

    private String userId;

    @Column(length = 50, nullable = false, unique = true)
    private String username;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 50, nullable = false)
    private String nickname;

    private boolean role; // user = true | admin = false

    @CreationTimestamp
    private Timestamp userCreatedAt;

    @Builder
    public User(String userId, String username, String password, String nickname, String userImage, boolean role, Timestamp userCreatedAt) {
        this.userId = userId;
        this.username = username;
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