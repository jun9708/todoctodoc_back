package kr.co.todoctodoc_back.user;

import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.servlet.http.HttpSession;
import kr.co.todoctodoc_back._core.utils.ApiUtils;
import kr.co.todoctodoc_back._core.utils.JwtTokenUtils;
import kr.co.todoctodoc_back.user._dto.UserReqDTO;
import kr.co.todoctodoc_back.user._dto.UserRespDTO;
import kr.co.todoctodoc_back.user.token.TokenRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserRestController {

    private final UserService userService;
    private final TokenRequest tokenRequest;
    private final HttpSession session;
    private final UserJPARepository userJPARepository;


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

    //일반 로그인
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserReqDTO.LoginDTO loginDTO){

        log.info("login 실행 : " +loginDTO);
        UserRespDTO.UserRegisterDTO userResponse = userService.userLogin(loginDTO);

        return ResponseEntity.ok()
                .header(userResponse.getToken())
                .body(ApiUtils.success(userResponse));

    }

    @GetMapping("/test")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok().body("test");
    }

    //회원가입
    @PostMapping("/register" )
    public ResponseEntity<?> userRegister(@RequestBody UserReqDTO.userRegisterDTO userRegisterDTO){

        log.info("userRegister 실행 : " +userRegisterDTO);
        UserRespDTO.UserRegisterDTO response = userService.userRegister(userRegisterDTO);

        return ResponseEntity.ok()
                .header(response.getToken())
                .body(ApiUtils.success(response));

    }


    //이메일 주소 조회
    @GetMapping("/domain")
    public ResponseEntity<?> domainCheck(){

        log.info("도메인 조회");
        UserRespDTO.DomainRespDTO domainRespDTO = userService.domainCheck();

        return ResponseEntity.ok()
                .header(domainRespDTO.toString())
                .body(ApiUtils.success(domainRespDTO));

    }

    //전화번호 중복 검사
    @PostMapping("/register_tel")
    public ResponseEntity<?> findByTel(@RequestBody UserReqDTO.findByTel findByTel){

        log.info("전화번호 중복검사 실행 : " +findByTel);
        UserRespDTO.findByTelResult response = userService.findByPhoneNumber(findByTel);

        return ResponseEntity.ok().header(response.getMessage()).body(ApiUtils.success(response));
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
