package kr.co.todoctodoc_back.symptomsCheck.mentalCheck;

import kr.co.todoctodoc_back._core.errors.exception.CustomRestfullException;
import kr.co.todoctodoc_back.symptomsCheck.mentalCheck._dto.MentalCheckReqDTO;
import kr.co.todoctodoc_back.symptomsCheck.mentalCheck._dto.MentalCheckRespDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MentalCheckService {

    private final MentalCheckJPARepository mentalCheckJPARepository;

    public MentalCheckRespDTO.mentalCheckRespDTO mentalCheckInsert(MentalCheckReqDTO.mentalCheckReqDTO mentalCheckReqDTO, String userId){

        // MentalCheck 테이블에서 userId 확인
        Optional<MentalCheck> existingMentalCheck = mentalCheckJPARepository.findByUserId(userId);

        if(existingMentalCheck.isPresent()){
            //이미 존재하는 경우 로직 수행하지 않음
            throw new CustomRestfullException("MentalCheck에 이미 등록되어있는 userId", HttpStatus.INTERNAL_SERVER_ERROR);
        }


        return null;
    }


}
