package kr.co.todoctodoc_back.hormoneLink;

import kr.co.todoctodoc_back._core.errors.exception.UnAuthorizedException;
import kr.co.todoctodoc_back._core.utils.JwtTokenUtils;
import kr.co.todoctodoc_back.hormoneLink._dto.HormoneLinkRespDTO;
import kr.co.todoctodoc_back.medicalRecord._dto.MedicalRecordReqDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Transactional
@RequiredArgsConstructor
@Service
public class HormoneLinkService {

    private final HormoneLinkJPARepository hormoneLinkRepository;

    public HormoneLinkRespDTO saveHormoneLink(MedicalRecordReqDTO medicalRecordReqDTO, String token) {
        log.info("hormoneTherapyNo 조회 : " + medicalRecordReqDTO);

        //토큰 사용자ID 추출
        String userId;
        try{
            userId = JwtTokenUtils.extractUserId(token);
        }catch (Exception e){
            throw new UnAuthorizedException("fail token");
        }

        //사용자 인증 확인
        if(userId == null || userId.isEmpty()){
            throw new UnAuthorizedException("error"); //사용자 인증실패
        }


        
        // userId와 hormoneTherapyNo를 추출
        List<Integer> hormoneTherapyNos = medicalRecordReqDTO.getHormoneTherapyNo();

        log.info("필살화약성 :  " +hormoneTherapyNos);

        // hormoneTherapyNo 리스트의 각 항목에 대해 HormoneLink 엔티티를 저장
        for (Integer hormoneTherapyNo : hormoneTherapyNos) {
            HormoneLink hormoneLink = new HormoneLink();


            // 저장
            hormoneLinkRepository.save(hormoneLink);
        }

        // 성공적으로 저장한 후의 응답을 생성하여 반환
        HormoneLinkRespDTO response = new HormoneLinkRespDTO();
        response.toString();
        return response;
    }
}