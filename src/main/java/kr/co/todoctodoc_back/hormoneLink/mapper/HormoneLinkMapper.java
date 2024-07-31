package kr.co.todoctodoc_back.hormoneLink.mapper;

import kr.co.todoctodoc_back.hormoneLink.HormoneLink;
import kr.co.todoctodoc_back.hormoneLink._dto.HormoneLinkRespDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HormoneLinkMapper {

    public HormoneLinkRespDTO.selectHormoneNoWhereUserId selectHormoneNo(int userNo);

}
