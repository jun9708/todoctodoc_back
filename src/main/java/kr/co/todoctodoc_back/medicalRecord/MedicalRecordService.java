package kr.co.todoctodoc_back.medicalRecord;

import jakarta.servlet.http.HttpSession;
import kr.co.todoctodoc_back._core.errors.exception.CustomRestfullException;
import kr.co.todoctodoc_back._core.errors.exception.Exception400;
import kr.co.todoctodoc_back._core.errors.exception.Exception500;
import kr.co.todoctodoc_back._core.errors.exception.UnAuthorizedException;
import kr.co.todoctodoc_back._core.utils.JwtTokenUtils;
import kr.co.todoctodoc_back.hormoneLink.HormoneLink;
import kr.co.todoctodoc_back.hormoneLink.HormoneLinkJPARepository;
import kr.co.todoctodoc_back.hormoneTherapy.HormoneTherapy;
import kr.co.todoctodoc_back.hormoneTherapy.HormoneTherapyJPARepository;
import kr.co.todoctodoc_back.medicalRecord._dto.MedicalRecordReqDTO;
import kr.co.todoctodoc_back.medicalRecord._dto.MedicalRecordRespDTO;
import kr.co.todoctodoc_back.user.User;
import kr.co.todoctodoc_back.user.UserJPARepository;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestHeader;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Transactional
@RequiredArgsConstructor
@Service
public class MedicalRecordService {

    @Autowired
    private MedicalRecordJPARepository medicalRecordJPARepository;
    @Autowired
    private HormoneTherapyJPARepository hormoneTherapyJPARepository;
    @Autowired
    private HttpSession httpSession;
    @Autowired
    private HormoneLinkJPARepository hormoneLinkJPARepository;
    @Autowired
    private UserJPARepository userJPARepository;

    public MedicalRecordRespDTO saveMedicalRecord(MedicalRecordReqDTO medicalRecordReqDTO, String userId) {


        // medicalRecord 테이블에서 userId 확인
        Optional<MedicalRecord> existingRecord = medicalRecordJPARepository.findByUserId("test@gmail.com");

        if (existingRecord.isPresent()) {
            // 이미 존재하는 경우 로직을 수행하지 않음
            throw new CustomRestfullException("이미 등록되어있는 userId",HttpStatus.INTERNAL_SERVER_ERROR);
        }

        int userNo = userJPARepository.findUserNoByUserId("test@gmail.com");

        MedicalRecord medicalRecord = MedicalRecord.builder()
                .userId(userId)
                .diagnosisDate(medicalRecordReqDTO.getDiagnosisDate())
                .surgeryDate(medicalRecordReqDTO.getSurgeryDate())
                .hormoneTherapyStartDate(medicalRecordReqDTO.getHormoneTherapyStartDate())
                .injectionStartDate(medicalRecordReqDTO.getInjectionStartDate())
                .hormoneTherapyName(medicalRecordReqDTO.getHormoneTherapyName())
                .createdAt(Timestamp.valueOf(LocalDateTime.now()))
                .build();

        medicalRecordJPARepository.save(medicalRecord);

        MedicalRecordRespDTO response = new MedicalRecordRespDTO();
        response.setMessage("진료정보 등록");


        return response;
    }
}