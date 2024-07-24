package kr.co.todoctodoc_back.medicalRecord;

import groovy.util.logging.Slf4j;
import kr.co.todoctodoc_back.hormoneTherapy.HormoneTherapy;
import kr.co.todoctodoc_back.hormoneTherapy.HormoneTherapyJPARepository;
import kr.co.todoctodoc_back.medicalRecord._dto.MedicalRecordReqDTO;
import kr.co.todoctodoc_back.medicalRecord._dto.MedicalRecordRespDTO;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@RequiredArgsConstructor
@Slf4j
@Service
public class MedicalRecordService {

    @Autowired
    private MedicalRecordJPARepository medicalRecordJPARepository;

    @Autowired
    private HormoneTherapyJPARepository hormoneTherapyJPARepository;

    public MedicalRecordRespDTO saveMedicalRecord(MedicalRecordReqDTO medicalRecordReqDTO) {
        MedicalRecord medicalRecord = new MedicalRecord();
        medicalRecord.setDiagnosisDate(medicalRecordReqDTO.getDiagnosisDate());
        medicalRecord.setSurgeryDate(medicalRecordReqDTO.getSurgeryDate());
        medicalRecord.setHormoneTherapyStartDate(medicalRecordReqDTO.getHormoneTherapyStartDate());

        List<HormoneTherapy> hormoneTherapies = medicalRecordReqDTO.getHormoneTherapies().stream()
                .map(dto -> {
                    HormoneTherapy hormoneTherapy = new HormoneTherapy();
                    hormoneTherapy.setName(hormoneTherapy.getName());
                    hormoneTherapy.setMedicalRecord(medicalRecord);
                    return hormoneTherapy;
                })
                .collect(Collectors.toList());

        medicalRecord.setHormoneTherapy(hormoneTherapies);

        medicalRecordJPARepository.save(medicalRecord);

        MedicalRecordRespDTO response = new MedicalRecordRespDTO();
        response.setId(medicalRecord.getId());
        response.setMessage("응답완료");

        return response;
    }
}