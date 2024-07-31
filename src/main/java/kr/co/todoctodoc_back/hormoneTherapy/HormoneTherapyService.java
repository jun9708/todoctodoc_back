package kr.co.todoctodoc_back.hormoneTherapy;

import kr.co.todoctodoc_back.hormoneTherapy._dto.HormoneTherapyResDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Transactional
@RequiredArgsConstructor
@Service
public class HormoneTherapyService {

    private final HormoneTherapyJPARepository hormoneTherapyJPARepository;

    //호르몬요법 조회
    public List<HormoneTherapyResDTO.therapyName> therapyCheck(){

        log.info("therapyCheck 서비스 실행");
        List<HormoneTherapy> hormoneTherapyList = hormoneTherapyJPARepository.findAll();


        log.info("테라피 리스트 : " +hormoneTherapyList);


        // 조회된 데이터를 therapyName 형식으로 변환
        List<HormoneTherapyResDTO.therapyName> therapyRespList = hormoneTherapyList.stream()
                .map(therapy -> {
                    HormoneTherapyResDTO.therapyName dto = new HormoneTherapyResDTO.therapyName();
                    dto.setHormoneNo(therapy.getHormoneTherapyNo());
                    dto.setTherapyName(therapy.getTherapyName());
                    return dto;
                })
                .collect(Collectors.toList());

        return therapyRespList;
    }



        /*
        List<HormoneTherapyResDTO> therapyResDTOList = hormoneTherapyList.stream()
                .map(hormoneTherapy -> new HormoneTherapyResDTO(
                        hormoneTherapy.getHormoneNo(),
                        hormoneTherapy.getTherapyName()))
                .collect(Collectors.toList());

         */

}
