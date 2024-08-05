package kr.co.todoctodoc_back.medicalRecord;

import kr.co.todoctodoc_back._core.errors.exception.CustomException;
import kr.co.todoctodoc_back._core.errors.exception.CustomRestfullException;
import kr.co.todoctodoc_back._core.errors.exception.Exception400;
import kr.co.todoctodoc_back._core.utils.ApiUtils;
import kr.co.todoctodoc_back.commonService.CommonService;
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
    @Autowired
    private CommonService commonService;

    @PostMapping("/medicalRecords")
    public ResponseEntity<?> saveMedicalRecord(@RequestBody MedicalRecordReqDTO medicalRecordReqDTO,
                                               @RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {

        log.info("saveMedicalRecord 실행 : " +medicalRecordReqDTO);

        // JWT 토큰에서 "Bearer " 부분을 제거하고 실제 토큰만 추출
        String token = authHeader.substring(7);

        // 유저체크
        String userId = commonService.tokenCheck(token);

        try{

            log.info("요청 값 : " +medicalRecordReqDTO);

            // hormoneLinkService 로직 수행
           // HormoneLinkRespDTO hormoneLinkRespDTO = hormoneLinkService.saveHormoneLink(medicalRecordReqDTO, userId);

            // medicalRecordService 로직 수행
            MedicalRecordRespDTO response = medicalRecordService.saveMedicalRecord(medicalRecordReqDTO, userId);

            // 성공적으로 처리되면 응답 반환
            return ResponseEntity.ok().header(response.getMessage()/*,hormoneLinkRespDTO.toString()*/).body(ApiUtils.success(userId));

        }catch (CustomRestfullException e) {
            // 클라이언트에 전달할 오류 응답 생성
            return ResponseEntity.status(e.getStatus())
                    .body(ApiUtils.error("medicalRecord error : " +e.getMessage() +" : ", e.status()));
        }
    }

}
