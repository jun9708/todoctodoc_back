package kr.co.todoctodoc_back.symptomsCheck.bodyCheck._details;

import kr.co.todoctodoc_back._core.errors.exception.CustomException;
import kr.co.todoctodoc_back._core.errors.exception.CustomRestfullException;
import kr.co.todoctodoc_back.commonService.CommonService;
import kr.co.todoctodoc_back.symptomsCheck.bodyCheck.BodyCheck;
import kr.co.todoctodoc_back.symptomsCheck.bodyCheck.BodyCheckJPARepository;
import kr.co.todoctodoc_back.symptomsCheck.bodyCheck._dto.BodyCheckReqDTO;
import kr.co.todoctodoc_back.symptomsCheck.bodyCheck._dto.BodyCheckRespDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BodyCheckDetailsService {

    @Autowired
    private final BodyCheckDetailsJPARepository bodyCheckDetailsJPARepository;
    @Autowired
    private final CommonService commonService;


    //BodyCheckPoint 저장
    public void saveBodyCheckPoint(BodyCheckReqDTO.bodyCheckReqDTO bodyCheckReqDTO, String userId){
        int userNo = commonService.selectUserNo(userId);

        log.info("saveBodyCheckPoint 실행");

        // 현재 시간을 createAt으로 설정
        Timestamp createAt = Timestamp.valueOf(LocalDateTime.now());
        bodyCheckReqDTO.setCreatedAt(createAt);

        LocalDate localDate = createAt.toLocalDateTime().toLocalDate();

        // 하루의 시작과 끝 시간 설정
        LocalDateTime startOfDay = localDate.atStartOfDay();
        LocalDateTime endOfDay = localDate.atTime(LocalTime.MAX);

        List<BodyCheckDetails> existingBodyChecksDetails = bodyCheckDetailsJPARepository.findByUserNoAndCreatedAtBetween(userNo, Timestamp.valueOf(startOfDay), Timestamp.valueOf(endOfDay));

        log.info("날짜 조회 : "  +existingBodyChecksDetails);

        if(!existingBodyChecksDetails.isEmpty()){
            //동일한 날짜에 데이터가 존재한다면 예외처리
            throw new CustomException("해당 날짜에 이미 데이터가 존재합니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        log.info("BodyCheckDetail 엔터티 등록 : ");

        //BodyCheckDetail 정보 저장
        BodyCheckDetails bodyCheckDetails = BodyCheckDetails.builder()
                .userNo(userNo)
                .userId(userId)
                .heatSensationScore(bodyCheckReqDTO.getHeatSensationScore())
                .cardiovascularScore(bodyCheckReqDTO.getCardiovascularScore())
                .sleepScore(bodyCheckReqDTO.getSleepScore())
                .painScore(bodyCheckReqDTO.getPainScore())
                .createdAt(Timestamp.valueOf(LocalDateTime.now()))
                .build();

        //생성된 bodyCheckDetail 데이터베이스에 저장
        bodyCheckDetailsJPARepository.save(bodyCheckDetails);

        log.info("bodyCheckDetails 저장");

        BodyCheckRespDTO.bodyCheckRespDTO response = new BodyCheckRespDTO.bodyCheckRespDTO();
        response.setMessage("bodyCheck 등록");

    }


    //userNo가 가지고있는 BodyCheckDetailsNo조회
    public void userBodyCheckDetailsNo(BodyCheckReqDTO.bodyCheckReqDTO bodyCheckReqDTO, int userNo){
        try{
            //userNo가 가지고 있는 bodyCheckDetailNo 조회
            Optional<BodyCheckDetails> bodyCheckDetails = bodyCheckDetailsJPARepository.findById(userNo);


        }catch (RuntimeException checkBodyCheckError){
            throw new CustomException("userId BodyCheckDetailNo Check error");
        }

    }


}
