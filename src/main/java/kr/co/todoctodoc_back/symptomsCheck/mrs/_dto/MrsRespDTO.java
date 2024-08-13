package kr.co.todoctodoc_back.symptomsCheck.mrs._dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class MrsRespDTO {

    @Data
    public static class AlarmDetail {
        private String no;
        private String day;
        private String date;
        private Timestamp userAlarm;

        public AlarmDetail(String day, String date) {
            this.day = day;
            this.date = date;
        }
    }

    @Data
    public static class mrsRespDTO {

        private AlarmDetail bodyCheckWeekAlarm;
        private AlarmDetail mentalCheckWeekAlarm;
        private AlarmDetail urinaryCheckWeekAlarm;

    }
}