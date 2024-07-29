package kr.co.todoctodoc_back.user._dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import kr.co.todoctodoc_back.user.User;
import lombok.Data;

@Data
public class UserRespDTO {
    

    // 회원
    @Data
    public static class UserRegisterDTO{

        private String userId;
        private String token;
        private String Message;

    }
    
    //전화번호 중복 검사 완료
    @Data
    public static class findByTelResult{
        private String tel;
        private String message;
    }
    

    // ME 메인, 프로필 페이지 요청
    @Data
    public static class UserDTO {
        private Integer userNo;
        private String userId;
        private String nickname;

        public UserDTO(User user) {
            this.userId = user.getUserid();
        }
    }

    @Data
    public static class LoginDTO {
        private UserLoginDTO user;
        private String token;

        public LoginDTO(User user, String token) {
            this.user = new UserLoginDTO(user);
            this.token = token;
        }

        @Data
        public static class UserLoginDTO {
            private String username;
            private String nickname;
            private String userImage;

            public UserLoginDTO(User user) {
                this.username = user.getUsername();
            }
        }
    }

    // ME 회원 탈퇴
    @Data
    public static class withDrawDTO {
        private Integer userNo;
        private String userId;
        private String nickname;

        public withDrawDTO(User user) {
            this.userId = user.getUserid();
        }
    }

    @Data
    @JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class KakaoProfile {
        private String id;
        private String connectedAt;
        private Propreties properties;

        @Data
        @JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
        public static class Propreties {
            private String nickname;
            private String profileImage;
            private String thumbnailImage;

        }
        public User toEntity(String password) {
            return User.builder()
                    .username(id)
                    .password(password)
                    .build();
        }

    }

    @Data
    @JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class NaverProfile {
        private String resultcode;
        private String message;
        private Profile response;

        @Data
        @JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
        public static class Profile {
            private String id;
            private String profileImage;
            private String name;

        }
        public User toEntity(String password) {
            return User.builder()
                    .username(response.id)
                    .password(password)
                    .build();
        }
    }



}
