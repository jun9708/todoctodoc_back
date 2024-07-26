package kr.co.todoctodoc_back.user;

import kr.co.todoctodoc_back._core.errors.exception.Exception404;
import kr.co.todoctodoc_back.user._dto.UserReqDTO;
import kr.co.todoctodoc_back.user._dto.UserRespDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserService {


    private final UserJPARepository userJPARepository;
    private final PasswordEncoder passwordEncoder;


    //회원가입 요청
    public UserRespDTO.UserRegisterDTO userRegister(UserReqDTO.userRegisterDTO userReqDTO){

        //비밀번호 인코더
        String encoded = passwordEncoder.encode(userReqDTO.getPassword());

        //아이디 중복검사
        Optional<User> optUser = userJPARepository.findByUserid(userReqDTO.getUserId());

        if(optUser.isEmpty()){
            //사용가능
            log.info("회원가입 서비스 실행" +userReqDTO);
            User userRegister = new User();
            userRegister.setUserid(userReqDTO.getUserId());
            userRegister.setUsername(userReqDTO.getUserName());
            userRegister.setBirth(userReqDTO.getBirth());
            userRegister.setTel(userReqDTO.getTel());
            userRegister.setPassword(userReqDTO.getPassword());
            userRegister.setNickname(userReqDTO.getNickname());
            userRegister.setRole(true);

            User saveUser = userJPARepository.save(userRegister);
            log.info("회원가입 완료 : " +saveUser);

            UserRespDTO.UserRegisterDTO response = new UserRespDTO.UserRegisterDTO();
            response.setUserId(userReqDTO.getUserId());
            response.setMessage("success : 회원가입 성공");

            log.info("결과 : " +response);

            return response;


        }else {
            UserRespDTO.UserRegisterDTO response = new UserRespDTO.UserRegisterDTO();
            response.setUserId(userReqDTO.getUserId());
            response.setMessage("fail : 중복된 아이디입니다");

            log.info("결과 : " +response);

            return response;

        }

    }


    //전화번호 중복 검사 요청
    public UserRespDTO.findByTelResult findByPhoneNumber(UserReqDTO.findByTel findByTel){

        log.info("전화번호 중복 검사 서비스 실행 : " +findByTel);
        Optional<User> optUser = userJPARepository.findByTel(findByTel.getTel());

        if(optUser.isEmpty()){

            //인증번호 전송
            log.info("인증번호 전송 !!" +findByTel);
            
            UserRespDTO.findByTelResult response = new UserRespDTO.findByTelResult();
            response.setTel(findByTel.getTel());
            response.setMessage("success : 인증번호가 전송되었습니다");
            return response;

        }else{

            log.info("이미 가입된 전화번호입니다");
            UserRespDTO.findByTelResult response = new UserRespDTO.findByTelResult();
            response.setTel(findByTel.getTel());
            response.setMessage("fail : 이미 가입한 전화번호입니다");

            return response;

        }
    }


    // ME 페이지 요청
    public UserRespDTO.UserDTO myPage(Integer userId) {
        User user = userJPARepository.findById(userId).orElseThrow(() -> new Exception404("해당 유저를 찾을 수 없습니다." + userId));
        return new UserRespDTO.UserDTO(user);
    }

    // ME 프로필 페이지 요청
    public UserRespDTO.UserDTO proflieDetail(Integer userId) {
        User user = userJPARepository.findById(userId).orElseThrow(() -> new Exception404("해당 유저를 찾을 수 없습니다." + userId));
        return new UserRespDTO.UserDTO(user);
    }

    // ME 프로필 수정
    @Transactional
    public UserRespDTO.UserDTO profileUpdate(UserReqDTO.ProfileUpdateDTO requestDTO, Integer userId) {

        System.out.println("유저 업데이트 서비스 진입 ");
        User user = userJPARepository.findById(userId).orElseThrow(() -> new Exception404("해당 유저를 찾을 수 없습니다." + userId));

        System.out.println("아이디 조회 잘해옴? " + user.toString());

        /*
        // 사진 디코딩
        if (!requestDTO.getUserImage().startsWith(requestDTO.getNickname())) {
            System.out.println("조건문 발동 " + user.getUserImage());
            String decodeImage = ImageUtils.decodeImage(requestDTO.getUserImage(), requestDTO.getNickname());
            user.updateNickname(requestDTO.getNickname());
            user.updateUserImage("/images/user/" + decodeImage);
          //  System.out.println("조건문 발동 잘바뀜? " + userOP.getNickname());
            return new UserRespDTO.UserDTO(user);
        }
         */

        user.updateNickname(requestDTO.getNickname());
     //   System.out.println("조건문 지남 " + userOP.getUserImage());
      // System.out.println("조건문 지남 " + userOP.getNickname());

        return new UserRespDTO.UserDTO(user);
    }

    // ME 회원 탈퇴
    @Transactional
    public UserRespDTO.withDrawDTO withDraw(Integer userId) {
        User user = userJPARepository.findById(userId).orElseThrow(() -> new Exception404("해당 유저를 찾을 수 없습니다." + userId));
        return new UserRespDTO.withDrawDTO(user);
    }

    /*
    public UserRespDTO.LoginDTO kakaoLogin(UserRespDTO.KakaoProfile dto) {

        // 유저 조회
        User user = userJPARepository.findByUsername(dto.getId());


        // 유저가 없으면 회원가입 시킨다.
        if (user == null) {
           User userOP = userJPARepository.save(dto.toEntity(tencoKey));
            // 토큰 생성
            String jwt = JwtTokenUtils.create(userOP);
           return new UserRespDTO.LoginDTO(userOP, jwt);
        } else {
            // 토큰 생성
            String jwt = JwtTokenUtils.create(user);
            return new UserRespDTO.LoginDTO(user, jwt);
        }
    }
     */

    /*
    public UserRespDTO.LoginDTO naverLogin(UserRespDTO.NaverProfile dto) {
        User user = userJPARepository.findByUsername(dto.getResponse().getId());


        // 유저가 없으면 회원가입 시킨다.
        if (user == null) {
            User userOP = userJPARepository.save(dto.toEntity(tencoKey));
            // 토큰 생성
           String jwt = JwtTokenUtils.create(userOP);
            return new UserRespDTO.LoginDTO(userOP, jwt);
        } else {
            // 토큰 생성
            String jwt = JwtTokenUtils.create(user);
            return new UserRespDTO.LoginDTO(user, jwt);
        }
    }
    */

    /*
    // Base64 데이터 여부를 확인하는 메서드
    private boolean isBase64Data(String data) {
        // 정규표현식으로 "data:image"로 시작하는지 확인
        String base64Pattern = "^data:image\\/([a-zA-Z]+);base64,.*$";
        return Pattern.matches(base64Pattern, data);
    }
     */
}
