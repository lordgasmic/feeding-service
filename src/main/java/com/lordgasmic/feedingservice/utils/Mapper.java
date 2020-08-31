package com.lordgasmic.feedingservice.utils;

import com.lordgasmic.feedingservice.entity.FeedingEntity;
import com.lordgasmic.feedingservice.model.FeedRequest;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Mapper {
    private Mapper(){}

    public static FeedingEntity toEntity(FeedRequest request) {
        FeedingEntity entity = new FeedingEntity();

        LocalTime lt = LocalTime.of(request.getTimeHour(), request.getTimeMinute());
        LocalDateTime ldt = LocalDateTime.of(Jbom.convertDate(request.getDate()), lt);
        ZonedDateTime zdt = ZonedDateTime.of(ldt, ZoneId.of("America/New_York"));

        entity.setTimestmp(zdt);
        entity.setGiven(request.getGiven());
        entity.setGivenUom(request.getGivenUom());
        entity.setQuantity(request.getQuantity());
        entity.setQuantityUom(request.getQuantityUom());
        entity.setVitamin(request.isVitamin());
        entity.setNote(request.getNote());

        return entity;
    }
}
