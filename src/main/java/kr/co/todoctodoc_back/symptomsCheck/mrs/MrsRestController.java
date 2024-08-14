package kr.co.todoctodoc_back.symptomsCheck.mrs;

import kr.co.todoctodoc_back.commonService.CommonService;
import kr.co.todoctodoc_back.symptomsCheck.bodyCheck.BodyCheckJPARepository;
import kr.co.todoctodoc_back.symptomsCheck.mentalCheck.MentalCheckJPARepository;
import kr.co.todoctodoc_back.symptomsCheck.mrs._dto.MrsRespDTO;
import kr.co.todoctodoc_back.symptomsCheck.urinaryCheck.UrinaryCheckJPARepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/mrs")
public class MrsRestController {

    private MrsService mrsService;
    private BodyCheckJPARepository bodyCheckJPARepository;
    private MentalCheckJPARepository mentalCheckJPARepository;
    private UrinaryCheckJPARepository urinaryCheckJPARepository;
    private CommonService commonService;

    @GetMapping("/alarms")
    public MrsRespDTO.mrsRespDTO getAllAlarms(@RequestHeader(HttpHeaders.AUTHORIZATION) String authHeader) {

        //JWT 토큰에서 "Bearer" 부분을 제거하고 실제 토큰만 추출
        String token = authHeader.substring(7);
        String userId = commonService.tokenCheck(token);

        //각 체크별 사용자 알람 조회

        Optional<Timestamp> bodyCheckAlarm = bodyCheckJPARepository.findBodyCheckAlarmByUserId(userId);




        MrsRespDTO.mrsRespDTO mrsRespDTO = new MrsRespDTO.mrsRespDTO();
        
        //user가 저장한 알람 시간 확인


        // 신체적 체크 알람 날짜 (다음 월요일)
        LocalDate nextMonday = getNextMonday();
        String bodyCheckDay = nextMonday.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        String bodyCheckDate = nextMonday.toString();
        mrsRespDTO.setBodyCheckWeekAlarm(new MrsRespDTO.AlarmDetail(bodyCheckDay, bodyCheckDate));

        // 정신적 체크 알람 날짜 (다음 화요일)
        LocalDate nextTuesday = getNextTuesday();
        String mentalCheckDay = nextTuesday.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        String mentalCheckDate = nextTuesday.toString();
        mrsRespDTO.setMentalCheckWeekAlarm(new MrsRespDTO.AlarmDetail(mentalCheckDay, mentalCheckDate));

        // 신체적 체크 알람 날짜 (다음 달 1일)
        LocalDate nextMonthFirstDay = getNextMonthFirstDay();
        String urinaryCheckDate = nextMonthFirstDay.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        mrsRespDTO.setUrinaryCheckWeekAlarm(new MrsRespDTO.AlarmDetail("Next Month", urinaryCheckDate));

        // 응답 문자열 구성
        return mrsRespDTO;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public String sendAlarmBodyCheck(){

        // 다음 월요일의 날짜와 요일 이름 계산
        LocalDate nextMonday = getNextMonday();
        String dayOfWeek = nextMonday.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

        // 응답 문자열 구성
        return dayOfWeek + " (" + nextMonday.toString() + ")";

    }

    // 다음 월요일의 날짜를 계산하는 메서드 (신체적)
    private LocalDate getNextMonday() {
        LocalDate now = LocalDate.now();
        return now.with(DayOfWeek.MONDAY);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public String sendAlarmMentalCheck(){

        // 다음 화요일의 날짜와 요일 이름 계산
        LocalDate nextTuesday = getNextTuesday();
        String dayOfWeek = nextTuesday.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

        // 응답 문자열 구성
        return dayOfWeek + " (" + nextTuesday.toString() + ")";

    }

    // 다음 화요일의 날짜를 계산하는 메서드 (정신적)
    private LocalDate getNextTuesday() {
        LocalDate now = LocalDate.now();
        return now.with(DayOfWeek.TUESDAY);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public String sendAlarmUrinaryCheck(){

        // 다음 달 1일의 날짜 계산
        LocalDate nextMonthFirstDay = getNextMonthFirstDay();
        String formattedDate = nextMonthFirstDay.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return "";

    }

    // 매월 1일 날짜를 계산하는 메서드 (신체적)
    private LocalDate getNextMonthFirstDay() {
        LocalDate now = LocalDate.now();
        return now.plusMonths(1).withDayOfMonth(1);
    }

}
