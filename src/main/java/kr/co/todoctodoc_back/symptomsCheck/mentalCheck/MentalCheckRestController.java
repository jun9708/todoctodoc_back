package kr.co.todoctodoc_back.symptomsCheck.mentalCheck;

import kr.co.todoctodoc_back._core.errors.exception.CustomRestfullException;
import kr.co.todoctodoc_back._core.utils.ApiUtils;
import kr.co.todoctodoc_back.commonService.CommonService;
import kr.co.todoctodoc_back.symptomsCheck.mentalCheck._details.MentalCheckDetailsService;
import kr.co.todoctodoc_back.symptomsCheck.mentalCheck._dto.MentalCheckReqDTO;
import kr.co.todoctodoc_back.symptomsCheck.mentalCheck._dto.MentalCheckRespDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/MentalCheck")
public class MentalCheckRestController {

    @Autowired
    private MentalCheckService mentalCheckService;
    @Autowired
    private MentalCheckDetailsService mentalCheckDetailsService;
    @Autowired
    private CommonService commonService;

    @PostMapping("/")
    public ResponseEntity<?> mentalCheck(@RequestBody MentalCheckReqDTO.mentalCheckReqDTO mentalCheckReqDTO,
                            @RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader){

        //JWT 토큰에서 "Bearer" 부분을 제거하고 실제 토큰만 추출
        String token = authHeader.substring(7);
        String userId = commonService.tokenCheck(token);

        try{
            mentalCheckDetailsService.saveMentalCheckPoint(mentalCheckReqDTO, userId);
            MentalCheckRespDTO.mentalCheckRespDTO mentalCheckRespResult = mentalCheckService.mentalCheckInsert(mentalCheckReqDTO, userId);

            return ResponseEntity.ok().header(mentalCheckRespResult.getMessage()).body(ApiUtils.success(userId));

        }catch(CustomRestfullException e){

            return ResponseEntity.status(e.getStatus())
                    .body(ApiUtils.error("mentalCheck error : " +e.getMessage() + " : ", e.getStatus()));

        }




    }


}
