package kr.co.todoctodoc_back.medicalRecord;

import kr.co.todoctodoc_back._core.utils.ApiUtils;
import kr.co.todoctodoc_back.medicalRecord._dto.MedicalRecordReqDTO;
import kr.co.todoctodoc_back.medicalRecord._dto.MedicalRecordRespDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
//@RequestMapping("/medicalRecords")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService medicalRecordService;

    @PostMapping("/medicalRecords")
    public ResponseEntity<?> saveMedicalRecord(@RequestBody MedicalRecordReqDTO medicalRecordReqDTO,
                                               @RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {

        // JWT 토큰에서 "Bearer " 부분을 제거하고 실제 토큰만 추출
        String token = authHeader.substring(7);

        log.info("saveMedicalRecord 실행 : " +medicalRecordReqDTO);
        MedicalRecordRespDTO response = medicalRecordService.saveMedicalRecord(medicalRecordReqDTO, token);
        return ResponseEntity.ok().header(response.getMessage()).body(ApiUtils.success(response));
    }

}
