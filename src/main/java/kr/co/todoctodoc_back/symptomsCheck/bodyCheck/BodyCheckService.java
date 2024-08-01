package kr.co.todoctodoc_back.symptomsCheck.bodyCheck;

import kr.co.todoctodoc_back.symptomsCheck.bodyCheck._dto.BodyCheckReqDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BodyCheckService {

    private final BodyCheckJPARepository bodyCheckJPARepository;

    //BodyCheck 등록
    public void bodyCheckInsert(BodyCheckReqDTO bodyCheckReqDTO){

        log.info("bodyCheckService 실행 : " +bodyCheckReqDTO);


    }

}
