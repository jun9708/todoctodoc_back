package kr.co.todoctodoc_back._core.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class TimestampUtils {

    public static String timeStampToDate(Timestamp time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(time);
    }

    public static String timeStampToDateAndTime(Timestamp time) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return simpleDateFormat.format(time);
    }

    public static String timeStampToDate(Timestamp time, String dateFormat) {
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
    	return simpleDateFormat.format(time);
    }
    // 한국 시간대로 현재 날짜와 시간 가져오기
    public static Timestamp findCurrnetTime() {
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        return Timestamp.valueOf(localDateTime);
    }
    // String 타입의 날짜를 Timestamp 타입으로 변경
    public static Timestamp convertToTimestamp(String dateString) {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedDate;
		try {
			parsedDate = dateFormat.parse(dateString);
			return new Timestamp(parsedDate.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
    }
	// 현재와 비교해 D-day를 반환하는 함수
	public static String formatDDay(Timestamp date) {
		ZoneId koreaZoneId = ZoneId.of("Asia/Seoul");
		LocalDate currentDate = LocalDate.now(koreaZoneId);
		String remainningDays = String.valueOf(currentDate.until(date.toLocalDateTime().toLocalDate()).getDays()) ;
		return "D-"+remainningDays;
	}
    
    
}
