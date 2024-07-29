package kr.co.todoctodoc_back.medicalRecord;

import jakarta.servlet.http.HttpSession;
import kr.co.todoctodoc_back.hormoneTherapy.HormoneTherapy;
import kr.co.todoctodoc_back.hormoneTherapy.HormoneTherapyJPARepository;
import kr.co.todoctodoc_back.medicalRecord._dto.MedicalRecordReqDTO;
import kr.co.todoctodoc_back.medicalRecord._dto.MedicalRecordRespDTO;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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

    public MedicalRecordRespDTO saveMedicalRecord(MedicalRecordReqDTO medicalRecordReqDTO) {
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setUserId(httpSession.getId());
        medicalRecord.setDiagnosisDate(medicalRecordReqDTO.getDiagnosisDate());
        medicalRecord.setSurgeryDate(medicalRecordReqDTO.getSurgeryDate());
        medicalRecord.setHormoneTherapyStartDate(medicalRecordReqDTO.getHormoneTherapyStartDate());

        log.info("호르몬요법 값 : " +medicalRecordReqDTO.getHormoneTherapies());

        List<HormoneTherapy> hormoneTherapies = medicalRecordReqDTO.getHormoneTherapies().stream()
                .map(name -> {
                    HormoneTherapy hormoneTherapy = new HormoneTherapy();
                    hormoneTherapy.setName(name);
                    hormoneTherapy.setUserId(medicalRecord.getUserId());
                    hormoneTherapy.setMedical_record_id(medicalRecord);
                    return hormoneTherapy;
                })
                .collect(Collectors.toList());

        medicalRecord.setHormoneTherapy(hormoneTherapies);
        medicalRecordJPARepository.save(medicalRecord);

        MedicalRecordRespDTO response = new MedicalRecordRespDTO();
        response.setMedicalNo(medicalRecord.getMedicalNo());
        response.setMessage("진료정보 등록");


        return response;
    }
}