package kr.co.todoctodoc_back.hormoneTherapy;

import kr.co.todoctodoc_back.hormoneTherapy._dto.HormoneTherapyResDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Transactional
@RequiredArgsConstructor
@Service
public class HormoneTherapyService {

    private final HormoneTherapyJPARepository hormoneTherapyJPARepository;

    //호르몬요법 조회
    public HormoneTherapyResDTO.therapyName therapyCheck(){

        log.info("therapyCheck 서비스 실행");
        List<HormoneTherapy> hormoneTherapyList = hormoneTherapyJPARepository.findAll();

        log.info("111"+hormoneTherapyList);

        /*
        List<HormoneTherapyResDTO> therapyResDTOList = hormoneTherapyList.stream()
                .map(hormoneTherapy -> new HormoneTherapyResDTO(
                        hormoneTherapy.getHormoneNo(),
                        hormoneTherapy.getTherapyName()))
                .collect(Collectors.toList());

         */


        HormoneTherapyResDTO.therapyName therapyNameRespDTO = new HormoneTherapyResDTO.therapyName();

        return therapyNameRespDTO;

    }


}
