package kr.co.todoctodoc_back.terms;

import kr.co.todoctodoc_back.terms._dto.TermsRespDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping
@RequiredArgsConstructor
@RestController
public class TermsRestController {

    private final TermsService termsService;

    /*
    //회원가입 약관 조회
    @GetMapping("/terms")
    public ResponseEntity<?> terms(Integer termsNo){

        termsNo = 1;
         TermsRespDTO.TermsDTO termsDTO = termsService.selectTerms(termsNo);

         log.info("조회성공 : " +termsDTO);

        return ResponseEntity.ok().body(ApiUtils.success(termsDTO));
    }
    */

    //회원가입 약관 조회
    @GetMapping("/terms")
    public TermsRespDTO.TermsDTO terms(Model model){
        int termsNo = 0;

        log.info("1. selectTerms 실행 ");

        TermsRespDTO.TermsDTO termsRespDTO = termsService.selectTerms();

        return termsRespDTO;
    }

}
