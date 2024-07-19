package kr.co.todoctodoc_back.user._dto;

import lombok.Data;

@Data
public class UserReqDTO {

    // ME 프로필 페이지 수정 요청
    @Data
    public static class ProfileUpdateDTO {
        private String nickname;
        private String userImage;
    }
    @Data
    public static class LoginDTO {
        private String socialName;
    }
}
