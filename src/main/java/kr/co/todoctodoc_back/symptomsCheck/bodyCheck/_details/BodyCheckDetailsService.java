package kr.co.todoctodoc_back.symptomsCheck.bodyCheck._details;

import kr.co.todoctodoc_back._core.errors.exception.CustomException;
import kr.co.todoctodoc_back.commonService.CommonService;
import kr.co.todoctodoc_back.symptomsCheck.bodyCheck.BodyCheck;
import kr.co.todoctodoc_back.symptomsCheck.bodyCheck.BodyCheckJPARepository;
import kr.co.todoctodoc_back.symptomsCheck.bodyCheck._dto.BodyCheckReqDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private final BodyCheckJPARepository bodyCheckJPARepository;
    @Autowired
    private final CommonService commonService;


    //BodyCheckPoint 저장
    public void saveBodyCheckPoint(BodyCheckReqDTO.bodyCheckReqDTO bodyCheckReqDTO, String userId){

        log.info("saveBodyCheckPoint 실행");

        int userNo = commonService.selectUserNo(userId);

        //날짜 조회
        Timestamp createAt = bodyCheckReqDTO.getCreatedAt();
        List<BodyCheckDetails> existingBodyChecksDetails = bodyCheckDetailsJPARepository.findByUserNoAndCreatedAt(userNo, createAt);

        log.info("날짜 조회 : "  +existingBodyChecksDetails);

        //존재하는 BodyCheck 동일한 날짜 데이터 조회 이후
        //조회된 데이터가 없다면
        if(existingBodyChecksDetails.isEmpty()){
            //BodyCheckDetail 정보 저장
            BodyCheckDetails bodyCheckDetails = BodyCheckDetails.builder()
                    .userNo(userNo)
                    .userId(userId)
                    .build();

        }
        else{
            //조회된 데이터가 있다면


        }





    }

    //Body_Check_No 조회
    public void getBodyCheckNoByUserNo(Integer userNo){




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
