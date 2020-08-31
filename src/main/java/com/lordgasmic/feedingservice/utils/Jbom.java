package com.lordgasmic.feedingservice.utils;

import java.time.LocalDate;
import java.time.LocalTime;

public class Jbom {

    public static LocalDate convertDate(String date){
        String[] splDate = date.split("/");
        return LocalDate.of(Integer.parseInt(splDate[2]),Integer.parseInt(splDate[0]),Integer.parseInt(splDate[1]));
    }
}
