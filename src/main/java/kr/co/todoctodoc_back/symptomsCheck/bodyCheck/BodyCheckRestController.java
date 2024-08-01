package kr.co.todoctodoc_back.symptomsCheck.bodyCheck;

import kr.co.todoctodoc_back.symptomsCheck.bodyCheck._dto.BodyCheckReqDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/BodyCheck")
public class BodyCheckRestController {

    private BodyCheckService bodyCheckService;

    @PostMapping("/")
    public void bodyCheck(@RequestBody BodyCheckReqDTO bodyCheckReqDTO){

        bodyCheckService.bodyCheckInsert(bodyCheckReqDTO);


    }

}
