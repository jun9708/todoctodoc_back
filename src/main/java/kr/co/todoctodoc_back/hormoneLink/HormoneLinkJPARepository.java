package kr.co.todoctodoc_back.hormoneLink;

import kr.co.todoctodoc_back.hormoneTherapy.HormoneTherapy;
import kr.co.todoctodoc_back.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HormoneLinkJPARepository extends JpaRepository<HormoneLink, Integer> {

    //medicalRecord 조회
    public List<HormoneLink> findByUserNo(int userNo);

}
