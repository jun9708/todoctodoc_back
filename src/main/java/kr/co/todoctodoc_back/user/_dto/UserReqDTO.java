package kr.co.todoctodoc_back.user._dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
public class UserReqDTO {


    //회원가입 요청
    @Data
    public static class userRegisterDTO{
        private String userId;
        private String userName;
        private String birth;
        private String tel;
        private String password;
        private String nickname;
    }

    //도메인조회
    @Data
    public static class domainDTO{
        private String domainName;
    }

    //전화번호 중복 검사 요청
    @Data
    public static class findByTel{
        private String tel;
    }

    // ME 프로필 페이지 수정 요청
    @Data
    public static class ProfileUpdateDTO {
        private String nickname;
        private String userImage;
    }
    @Data
    public static class LoginDTO {
        private String userId;
        private String password;
        private String socialName;
    }
}
