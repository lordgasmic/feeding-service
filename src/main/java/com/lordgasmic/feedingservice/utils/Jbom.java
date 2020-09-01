package com.lordgasmic.feedingservice.utils;

import com.lordgasmic.feedingservice.model.Meridiem;

import java.time.LocalDate;
import java.time.LocalTime;

public class Jbom {

    public static LocalDate convertDate(String date){
        String[] splDate = date.split("/");
        return LocalDate.of(Integer.parseInt(splDate[2]),Integer.parseInt(splDate[0]),Integer.parseInt(splDate[1]));
    }

    public static LocalTime buildLocalTime(int timeHour, int timeMinute, Meridiem meridiem) {
        if (meridiem == Meridiem.am) {
            return LocalTime.of(timeHour, timeMinute);
        }

        int correctedHour = (timeHour + 12) % 24;
        return LocalTime.of(correctedHour, timeMinute);
    }
}
