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

import java.util.List;
import java.util.Optional;

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

        //BodyCheck 테이블에 userNo 조회
        Optional<BodyCheck> existinBodyCheck = bodyCheckJPARepository.findByUserId(userId);


        log.info("userNo 조회 : " +existinBodyCheck);

        userBodyCheckDetailsNo(bodyCheckReqDTO, userNo);





    }

    //Body_Check_No 조회
    public void getBodyCheckNoByUserNo(Integer userNo){




    }



    //userNo가 가지고있는 BodyCheckDetailsNo조회
    public void userBodyCheckDetailsNo(BodyCheckReqDTO.bodyCheckReqDTO bodyCheckReqDTO, int userNo){
        try{
            //userNo가 가지고 있는 bodyCheckDetailNo 조회


        }catch (RuntimeException checkBodyCheckError){
            throw new CustomException("userId BodyCheckDetailNo Check error");
        }

    }

}
