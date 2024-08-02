package kr.co.todoctodoc_back.commonService;

import kr.co.todoctodoc_back._core.errors.exception.CustomException;
import kr.co.todoctodoc_back._core.utils.JwtTokenUtils;
import kr.co.todoctodoc_back.user.UserJPARepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CommonService {

    @Autowired
    private final UserJPARepository userJPARepository;

    //token 인증 확인
    public String tokenCheck(String token) {

        //토큰 사용자ID 추출
        String userId;

        try {
            userId = JwtTokenUtils.extractUserId(token);
        } catch (Exception e) {
            throw new CustomException("saveMedicalRecord : Token error");
        }

        //사용자 인증 확인
        if (userId == null || userId.isEmpty()) {
            throw new CustomException("saveMedicalRecord : Token Check error"); //사용자 인증실패
        }

        return userId;

    }

    //userId를 활용하여 userNo 조회
    public int selectUserNo(String userId){

        int userNo = userJPARepository.findUserNoByUserId(userId);

        log.info("userNo 조회 : " +userNo);

        return userNo;

    }

}
