package kr.co.todoctodoc_back.symptomsCheck.mentalCheck;

import kr.co.todoctodoc_back.commonService.CommonService;
import kr.co.todoctodoc_back.symptomsCheck.mentalCheck._details.MentalCheckDetailsService;
import kr.co.todoctodoc_back.symptomsCheck.mentalCheck._dto.MentalCheckReqDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public void mentalCheck(@RequestBody MentalCheckReqDTO.mentalCheckReqDTO mentalCheckReqDTO){




    }


}
