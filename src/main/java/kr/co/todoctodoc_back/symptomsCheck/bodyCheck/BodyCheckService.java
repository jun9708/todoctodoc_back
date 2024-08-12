package kr.co.todoctodoc_back.symptomsCheck.bodyCheck;

import kr.co.todoctodoc_back._core.errors.exception.CustomException;
import kr.co.todoctodoc_back._core.errors.exception.CustomRestfullException;
import kr.co.todoctodoc_back._core.errors.exception.Exception400;
import kr.co.todoctodoc_back._core.utils.JwtTokenUtils;
import kr.co.todoctodoc_back.commonService.CommonService;
import kr.co.todoctodoc_back.medicalRecord.MedicalRecord;
import kr.co.todoctodoc_back.symptomsCheck.bodyCheck._details.BodyCheckDetails;
import kr.co.todoctodoc_back.symptomsCheck.bodyCheck._details.BodyCheckDetailsJPARepository;
import kr.co.todoctodoc_back.symptomsCheck.bodyCheck._dto.BodyCheckReqDTO;
import kr.co.todoctodoc_back.symptomsCheck.bodyCheck._dto.BodyCheckRespDTO;
import kr.co.todoctodoc_back.user.UserJPARepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BodyCheckService {

    private final UserJPARepository userJPARepository;
    private final BodyCheckJPARepository bodyCheckJPARepository;
    private final BodyCheckDetailsJPARepository bodyCheckDetailsJPARepository;

    //BodyCheck 등록
    public BodyCheckRespDTO.bodyCheckRespDTO bodyCheckInsert(BodyCheckReqDTO.bodyCheckReqDTO bodyCheckReqDTO, String userId){

        log.info("사용자 확인 : " +userId);

        // BodyCheck 테이블에서 userId 확인
        Optional<BodyCheck> existingBodyCheck = bodyCheckJPARepository.findByUserId(userId);

        if (existingBodyCheck.isPresent()) {
            // 이미 존재하는 경우 로직을 수행하지 않음
            throw new CustomRestfullException("BodyCheck에 이미 등록되어있는 userId", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        int userNo = userJPARepository.findUserNoByUserId(userId);
        int bodyCheckScore = bodyCheckReqDTO.getCardiovascularScore()+
                bodyCheckReqDTO.getPainScore()+
                bodyCheckReqDTO.getSleepScore()+
                bodyCheckReqDTO.getHeatSensationScore();

        log.info("bodyCheck 총점 : " +bodyCheckScore);

        BodyCheck bodyCheck = BodyCheck.builder()
                .userNo(userNo)
                .userId(userId)
                .bodyCheckAlarm(bodyCheckReqDTO.getBodyCheckAlarm())
                .bodyCheckScore(bodyCheckScore)
                .createdAt(Timestamp.valueOf(LocalDateTime.now()))
                .build();

        //생성된 bodyCheck 데이터베이스에 저장
        bodyCheckJPARepository.save(bodyCheck);

        BodyCheckRespDTO.bodyCheckRespDTO response = new BodyCheckRespDTO.bodyCheckRespDTO();
        response.setMessage("bodyCheck 등록");

        return response;

    }

}
