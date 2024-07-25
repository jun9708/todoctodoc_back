package kr.co.todoctodoc_back.terms;

import kr.co.todoctodoc_back.terms._dto.TermsRespDTO;
import kr.co.todoctodoc_back.terms.mapper.TermsMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class TermsService {

    private final TermsJPARepository termsJPARepository;

    /*
    //회원가입 이용약관 조회
    public TermsRespDTO.TermsDTO selectTerms(Integer termsNo){

        log.info("termsNo : " +termsNo);
        Optional<Terms> optTerms = termsJPARepository.findById(termsNo);

        TermsRespDTO.TermsDTO termsDTO = new TermsRespDTO.TermsDTO();

        if (optTerms.isPresent()) {
            Terms terms = optTerms.get();
            termsDTO.setContent1(terms.getContent1());
            termsDTO.setContent2(terms.getContent2());
            termsDTO.setContent3(terms.getContent3());
        } else {
            // 데이터가 없을 경우의 처리
            log.warn("Terms not found for id: " + termsNo);
            // 필요에 따라 여기서 예외를 던지거나, 기본 값 설정 가능
        }

        return termsDTO;
    }
     */

    //이용약관 동의 출력

    private final TermsMapper termsMapper;

    public TermsRespDTO.TermsDTO selectTerms(){
        log.info("service 실행");

        int termsNo = 1;
        TermsRespDTO.TermsDTO respDTO = termsMapper.selectTerms(termsNo);

        log.info("service 종료");

        return respDTO;
    }


}
