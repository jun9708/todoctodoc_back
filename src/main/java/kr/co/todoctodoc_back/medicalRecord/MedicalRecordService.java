package kr.co.todoctodoc_back.medicalRecord;

import groovy.util.logging.Slf4j;
import kr.co.todoctodoc_back.medicalRecord._dto.MedicalRecordReqDTO;
import kr.co.todoctodoc_back.medicalRecord._dto.MedicalRecordRespDTO;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Slf4j
@Service
public class MedicalRecordService {

    private final MedicalRecordJPARepository medicalRecordJPARepository;

    public MedicalRecordRespDTO saveMedicalRecord(MedicalRecordReqDTO medicalRecordReqDTO) {
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setDiagnosisDate(medicalRecordReqDTO.getDiagnosisDate());
        medicalRecord.setSurgeryDate(medicalRecordReqDTO.getSurgeryDate());
        medicalRecord.setHormoneTherapy(medicalRecordReqDTO.getHormoneTherapy());
        medicalRecord.setHormoneTherapyStartDate(medicalRecordReqDTO.getHormoneTherapyStartDate());

        medicalRecordJPARepository.save(medicalRecord);

        MedicalRecordRespDTO response = new MedicalRecordRespDTO();
        response.setHormoneNo(medicalRecord.getHormoneNo());
        response.setMessage("진료진단 확인");

        return response;

    }
}
