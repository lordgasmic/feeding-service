package com.lordgasmic.feedingservice.model;

import lombok.Data;

import java.util.List;

@Data
public class FeedResponse {

    private String date;
    private int timeHour;
    private int timeMinute;
    private Meridiem meridiem;
    private List<Bottle> bottles;
}
