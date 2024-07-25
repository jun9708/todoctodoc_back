package kr.co.todoctodoc_back.terms.mapper;

import kr.co.todoctodoc_back.terms._dto.TermsRespDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TermsMapper {

    //이용약관 동의 출력
    public TermsRespDTO.TermsDTO selectTerms(int termsNo);

}
