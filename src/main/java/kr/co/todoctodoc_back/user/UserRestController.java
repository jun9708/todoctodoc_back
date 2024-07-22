package kr.co.todoctodoc_back.user;

import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.http.HttpSession;
import kr.co.todoctodoc_back._core.utils.ApiUtils;
import kr.co.todoctodoc_back._core.utils.JwtTokenUtils;
import kr.co.todoctodoc_back.user._dto.UserReqDTO;
import kr.co.todoctodoc_back.user._dto.UserRespDTO;
import kr.co.todoctodoc_back.user.token.TokenRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserRestController {

    private final UserService userService;
    private final TokenRequest tokenRequest;
    private final HttpSession session;


    /*
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserReqDTO.LoginDTO dto,
                                   @RequestHeader("Authorization") String token) {
        System.out.println("로그인 컨트롤러 진입 " + dto.getSocialName());
        System.out.println("로그인 컨트롤러 진입 " + token);

        // 카카오 로그인 처리 로직
        if (dto.getSocialName().equals("카카오톡")) {
            System.out.println("카카오톡 걸림");
            UserRespDTO.KakaoProfile kakaoProfile = tokenRequest.kakaoTokenRequest(token);
            System.out.println("카카오톡 정보 잘 가져옴? " + kakaoProfile.getProperties().getNickname());
            UserRespDTO.LoginDTO response = userService.kakaoLogin(kakaoProfile);
            System.out.println("유저 저장 완료?" + response);
            return ResponseEntity.ok().header("Authorization",
                    response.getToken()).body(ApiUtils.success(response.getUser()));
        }

        // 네이버 로그인 처리 로직
        if (dto.getSocialName().equals("네이버")) {
            System.out.println("네이버 걸림");
            UserRespDTO.NaverProfile naverProfile = tokenRequest.naverTokenRequest(token);
            System.out.println("네이버 정보 잘 가져옴? " + naverProfile.getResponse().getName());
            UserRespDTO.LoginDTO response = userService.naverLogin(naverProfile);
            System.out.println("유저 저장 완료?" + response);
            return ResponseEntity.ok().header("Authorization",
                    response.getToken()).body(ApiUtils.success(response.getUser()));
        }

        return ResponseEntity.ok().body(ApiUtils.error("잘못된 접근입니다.", HttpStatus.BAD_REQUEST));
    }
     */


    @GetMapping("/test")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok().body("test");
    }


    // ME 메인 페이지 요청
    // localhost:8080/user/my-page
    @GetMapping("/my-page")
    public ResponseEntity<?> myPage(@RequestHeader("Authorization") String token) {
        DecodedJWT decodedJWT = JwtTokenUtils.verify(token);
        Integer userId = decodedJWT.getClaim("id").asInt();
        UserRespDTO.UserDTO responseDTO = userService.myPage(userId);
        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }

    // ME 프로필 페이지 요청
    // localhost:8080/user/my-page/profile
    @GetMapping("/my-page/profile")
    public ResponseEntity<?> profilePage(@RequestHeader("Authorization") String token) {
        DecodedJWT decodedJWT = JwtTokenUtils.verify(token);
        Integer userId = decodedJWT.getClaim("id").asInt();
        UserRespDTO.UserDTO responseDTO = userService.proflieDetail(userId);
        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }


    // ME 프로필 수정
    // localhost:8080/user/my-page/profile
    @PutMapping("/my-page/profile")
    public ResponseEntity<?> profileUpdate(@RequestBody UserReqDTO.ProfileUpdateDTO requestDTO, @RequestHeader("Authorization") String token) {
        DecodedJWT decodedJWT = JwtTokenUtils.verify(token);
        Integer userId = decodedJWT.getClaim("id").asInt();
        UserRespDTO.UserDTO responseDTO = userService.profileUpdate(requestDTO, userId);

        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }

    // ME 로그아웃
    // localhost:8080/user/logout
    @GetMapping("/logout")
    public ResponseEntity<?> logout() {
        session.invalidate();
        return ResponseEntity.ok().body(ApiUtils.success("로그아웃 완료"));
    }

    // ME 회원탈퇴
    // localhost:8080/user/withDraw
    @PutMapping("/withDraw")
    public ResponseEntity<?> withDraw(@RequestHeader("Authorization") String token) {
        DecodedJWT decodedJWT = JwtTokenUtils.verify(token);
        Integer userId = decodedJWT.getClaim("id").asInt();
        UserRespDTO.withDrawDTO responseDTO = userService.withDraw(userId);
        return ResponseEntity.ok().body(ApiUtils.success(responseDTO));
    }
}
