package kr.co.todoctodoc_back.symptomsCheck.mentalCheck._details;

import kr.co.todoctodoc_back._core.errors.exception.CustomException;
import kr.co.todoctodoc_back.commonService.CommonService;
import kr.co.todoctodoc_back.symptomsCheck.mentalCheck.MentalCheckJPARepository;
import kr.co.todoctodoc_back.symptomsCheck.mentalCheck._dto.MentalCheckReqDTO;
import kr.co.todoctodoc_back.symptomsCheck.mentalCheck._dto.MentalCheckRespDTO;
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

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MentalCheckDetailsService {


    @Autowired
    private final MentalCheckJPARepository mentalCheckJPARepository;
    @Autowired
    private final CommonService commonService;
    @Autowired
    private MentalCheckDetailsJPARepository mentalCheckDetailsJPARepository;

    public void saveMentalCheckPoint(MentalCheckReqDTO.mentalCheckReqDTO mentalCheckReqDTO, String userId){

        int userNo = commonService.selectUserNo(userId);
        
        log.info("saveMentalCheckPoint 실행");

        //g현재 시간을 creatAt으로 설정
        Timestamp creatAt = Timestamp.valueOf(LocalDateTime.now());
        mentalCheckReqDTO.setCreatedAt(creatAt);

        LocalDate localDate = creatAt.toLocalDateTime().toLocalDate();

        //하루의 시작과 끝 시간 설정
        LocalDateTime startOfDay = localDate.atStartOfDay();
        LocalDateTime endOfDay = localDate.atTime(LocalTime.MAX);

        List<MentalCheckDetails> existingMentalChecksDetails = mentalCheckDetailsJPARepository.findByUserNoAndCreatedAtBetween(userNo, Timestamp.valueOf(startOfDay), Timestamp.valueOf(endOfDay));

        log.info("날짜 조회 : " +existingMentalChecksDetails);

        if(!existingMentalChecksDetails.isEmpty()){
            //동일한 날짜에 데이터가 존재한다면 예외처리
            throw new CustomException("해당 날짜에 이미 데이터가 존재합니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        log.info("mentalCheckDetail 엔터티 등록");

        //MentalCheckDetail 정보 저장
        MentalCheckDetails mentalCheckDetails = MentalCheckDetails.builder()
                .userNo(userNo)
                .userId(userId)
                .mentalScore1(mentalCheckReqDTO.getMentalScore1())
                .mentalScore2(mentalCheckReqDTO.getMentalScore2())
                .mentalScore3(mentalCheckReqDTO.getMentalScore3())
                .createdAt(Timestamp.valueOf(LocalDateTime.now()))
                .build();

        //생성된 bodyCheckDetail 데이터베이스에 저장
        mentalCheckDetailsJPARepository.save(mentalCheckDetails);

        log.info("mentalCheckDetail 저장");

        MentalCheckRespDTO.mentalCheckRespDTO response = new MentalCheckRespDTO.mentalCheckRespDTO();
        response.setMessage("mentalCheck 등록");

    }

}
