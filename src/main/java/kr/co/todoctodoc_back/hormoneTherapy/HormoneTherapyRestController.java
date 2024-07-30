package kr.co.todoctodoc_back.hormoneTherapy;

import kr.co.todoctodoc_back._core.utils.ApiUtils;
import kr.co.todoctodoc_back.hormoneTherapy._dto.HormoneTherapyResDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
public class HormoneTherapyRestController {

    @Autowired
    private HormoneTherapyService hormoneTherapyService;

    //호르몬 테라피 조회
    @GetMapping("/therapy")
    public ResponseEntity<?> therapyCheck(){

        log.info("therapyCheck 실행 ");
        HormoneTherapyResDTO.therapyName therapyName = hormoneTherapyService.therapyCheck();


        return ResponseEntity.ok().header(therapyName.toString()).body(ApiUtils.success(therapyName));

    }

}
