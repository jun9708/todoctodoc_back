package kr.co.todoctodoc_back.symptomsCheck.bodyCheck;

import kr.co.todoctodoc_back._core.errors.exception.CustomRestfullException;
import kr.co.todoctodoc_back._core.utils.ApiUtils;
import kr.co.todoctodoc_back.commonService.CommonService;
import kr.co.todoctodoc_back.symptomsCheck.bodyCheck._details.BodyCheckDetailsService;
import kr.co.todoctodoc_back.symptomsCheck.bodyCheck._dto.BodyCheckReqDTO;
import kr.co.todoctodoc_back.symptomsCheck.bodyCheck._dto.BodyCheckRespDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/BodyCheck")
public class BodyCheckRestController {


    @Autowired
    private BodyCheckService bodyCheckService;
    @Autowired
    private BodyCheckDetailsService bodyCheckDetailsService;
    @Autowired
    private CommonService commonService;

    @PostMapping("/")
    public ResponseEntity<?> bodyCheck(@RequestBody BodyCheckReqDTO.bodyCheckReqDTO bodyCheckReqDTO,
                          @RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader){

        // JWT 토큰에서 "Bearer " 부분을 제거하고 실제 토큰만 추출
        String token = authHeader.substring(7);
        String userId = commonService.tokenCheck(token);
        
        try{
            log.info("bodyCheckDetailsService 시작전 : ");
            bodyCheckDetailsService.saveBodyCheckPoint(bodyCheckReqDTO, userId);
            BodyCheckRespDTO.bodyCheckRespDTO bodyCheckRespResult = bodyCheckService.bodyCheckInsert(bodyCheckReqDTO, userId);

            return ResponseEntity.ok().header(bodyCheckRespResult.getMessage()).body(ApiUtils.success(userId));

        }catch (CustomRestfullException e){

            // 클라이언트에 전달할 오류 응답 생성
            return ResponseEntity.status(e.getStatus())
                    .body(ApiUtils.error("bodyCheck error : " +e.getMessage() + " : ", e.status()));

        }

    }

}
