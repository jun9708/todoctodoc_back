package kr.co.todoctodoc_back.medicalRecord;

import kr.co.todoctodoc_back._core.errors.exception.Exception400;
import kr.co.todoctodoc_back._core.utils.ApiUtils;
import kr.co.todoctodoc_back.hormoneLink.HormoneLink;
import kr.co.todoctodoc_back.hormoneLink.HormoneLinkService;
import kr.co.todoctodoc_back.hormoneLink._dto.HormoneLinkRespDTO;
import kr.co.todoctodoc_back.medicalRecord._dto.MedicalRecordReqDTO;
import kr.co.todoctodoc_back.medicalRecord._dto.MedicalRecordRespDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
//@RequestMapping("/medicalRecords")
public class MedicalRecordController {

    @Autowired
    private MedicalRecordService medicalRecordService;
    @Autowired
    private HormoneLinkService hormoneLinkService;

    @PostMapping("/medicalRecords")
    public ResponseEntity<?> saveMedicalRecord(@RequestBody MedicalRecordReqDTO medicalRecordReqDTO,
                                               @RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {
        log.info("saveMedicalRecord 실행 : " +medicalRecordReqDTO);

        // JWT 토큰에서 "Bearer " 부분을 제거하고 실제 토큰만 추출
        String token = authHeader.substring(7);

        try{
            // hormoneLinkService 로직 수행

            log.info("요청 값 : " +medicalRecordReqDTO);
            HormoneLinkRespDTO hormoneLinkRespDTO = hormoneLinkService.saveHormoneLink(medicalRecordReqDTO, token);

            // medicalRecordService 로직 수행
            MedicalRecordRespDTO response = medicalRecordService.saveMedicalRecord(medicalRecordReqDTO, token);

            // 성공적으로 처리되면 응답 반환
            return ResponseEntity.ok().header(response.getMessage(),hormoneLinkRespDTO.toString()).body(ApiUtils.success(response));

        }catch (Exception e){
            throw new Exception400("medicalRecord 중복발생");
        }

    }

}
