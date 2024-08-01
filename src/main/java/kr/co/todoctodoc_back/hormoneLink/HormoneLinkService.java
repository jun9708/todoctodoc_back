package kr.co.todoctodoc_back.hormoneLink;

import kr.co.todoctodoc_back._core.errors.exception.Exception400;
import kr.co.todoctodoc_back._core.errors.exception.UnAuthorizedException;
import kr.co.todoctodoc_back._core.utils.JwtTokenUtils;
import kr.co.todoctodoc_back.hormoneLink._dto.HormoneLinkRespDTO;
import kr.co.todoctodoc_back.hormoneLink.mapper.HormoneLinkMapper;
import kr.co.todoctodoc_back.medicalRecord._dto.MedicalRecordReqDTO;
import kr.co.todoctodoc_back.user.UserJPARepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Transactional
@RequiredArgsConstructor
@Service
public class HormoneLinkService {

    private final HormoneLinkJPARepository hormoneLinkRepository;
    private final UserJPARepository userJPARepository;
    private final HormoneLinkJPARepository hormoneLinkJPARepository;
    private final HormoneLinkMapper hormoneLinkMapper;

    public HormoneLinkRespDTO saveHormoneLink(MedicalRecordReqDTO medicalRecordReqDTO, String token) {
        log.info("hormoneTherapyNo 조회 : " + medicalRecordReqDTO);

        //토큰 사용자ID 추출
        String userId;
        try{
            userId = JwtTokenUtils.extractUserId(token);
        }catch (Exception e){
            throw new Exception400("saveHormoneLink : Token error");
        }

        //사용자 인증 확인
        if(userId == null || userId.isEmpty()){
            throw new Exception400("saveHormoneLink : Token Check error"); //사용자 인증실패
        }

        //userNO 조회
        int userNo = userJPARepository.findUserNoByUserId(userId);
        //userNo가 가지고있는 hormone_therapy_no 조회
        Set<Integer> newHormoneTherapyNos = userHormoneTherapyNo(medicalRecordReqDTO, userNo);

        // userId와 hormoneTherapyNo를 추출
        //List<Integer> hormoneTherapyNos = medicalRecordReqDTO.getHormoneTherapyNo();

        // hormoneTherapyNo 리스트의 각 항목에 대해 HormoneLink 엔티티를 저장
        for (Integer hormoneTherapyNo : newHormoneTherapyNos) {
            HormoneLink hormoneLink = HormoneLink.builder()
                    .userNo(userNo)
                    .hormoneTherapyNo(hormoneTherapyNo)
                    .createdAt(Timestamp.valueOf(LocalDateTime.now()))
                    .build();

            // 저장
            hormoneLinkRepository.save(hormoneLink);
        }

        // 성공적으로 저장한 후의 응답을 생성하여 반환
        HormoneLinkRespDTO response = new HormoneLinkRespDTO();
        response.toString();
        return response;

    }

    //hormone_therapy_no 조회
    public List<Integer> getHormoneTherapyNoByUserNo(Integer userNo) {

        List<HormoneLink> hormoneLinks = hormoneLinkJPARepository.findByUserNo(userNo);

        return hormoneLinks.stream()
                .map(HormoneLink::getHormoneTherapyNo)
                .collect(Collectors.toList());

    }

    //userNo가 가지고있는 hormone_therapy_no 조회
    public Set<Integer> userHormoneTherapyNo(MedicalRecordReqDTO medicalRecordReqDTO, int userNo) {

        try{
            //userId가 가지고있는 hormone_therapy_no 조회
            List<Integer> currentHormoneTherapyNumbers = getHormoneTherapyNoByUserNo(userNo);
            List<Integer> requestHormoneTherapyNos = medicalRecordReqDTO.getHormoneTherapyNo();


            // 현재 저장된 hormone_therapy_no와 요청받은 hormone_therapy_no 목록을 Set으로 변환
            Set<Integer> currentHormoneTherapySet = new HashSet<>(currentHormoneTherapyNumbers);
            Set<Integer> requestHormoneTherapySet = new HashSet<>(requestHormoneTherapyNos);

            // 요청받은 목록에서 현재 저장된 목록에 없는 항목만 필터링
            Set<Integer> newHormoneTherapyNos = requestHormoneTherapySet.stream()
                    .filter(hormoneTherapyNo -> !currentHormoneTherapySet.contains(hormoneTherapyNo))
                    .collect(Collectors.toSet());

            return newHormoneTherapyNos;

        } catch (RuntimeException checkHormoneTherapyError) {
            throw new Exception400("userId hormone_therapy_no Check error");
        }

    }


}