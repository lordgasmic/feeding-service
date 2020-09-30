package com.lordgasmic.feedingservice.utils;

import com.lordgasmic.feedingservice.entity.BottleEntity;
import com.lordgasmic.feedingservice.entity.BottleEntityPK;
import com.lordgasmic.feedingservice.entity.FeedingEntity;
import com.lordgasmic.feedingservice.model.Bottle;
import com.lordgasmic.feedingservice.model.FeedRequest;
import com.lordgasmic.feedingservice.model.FeedResponse;
import com.lordgasmic.feedingservice.model.Meridiem;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class Mapper {
    private Mapper(){}

    public static FeedingEntity toFeedingEntity(FeedRequest request) {
        FeedingEntity entity = new FeedingEntity();

        entity.setTimestmp(buildZDT(request));

        return entity;
    }

    public static FeedResponse toFeedResponse(FeedingEntity entity) {
        FeedResponse response = new FeedResponse();
        ZonedDateTime zdt = entity.getTimestmp();
        response.setTimeHour(zdt.getHour());
        response.setTimeMinute(zdt.getMinute());
        response.setMeridiem(zdt.getHour() < 12? Meridiem.am: Meridiem.pm);
        response.setDate(buildDate(zdt));

        return response;
    }

    public static List<BottleEntity> toBottleEntity(FeedRequest request) {
        List<BottleEntity> bottles = new ArrayList<>();

        ZonedDateTime zdt = buildZDT(request);

        for (Bottle bottle : request.getBottles()) {
            BottleEntityPK pk = new BottleEntityPK();
            pk.setOrdinal(bottle.getOrdinal());
            pk.setTimestmp(zdt);

            BottleEntity entity = new BottleEntity();
            entity.setPk(pk);
            entity.setGiven(bottle.getGiven());
            entity.setGivenUom(bottle.getGivenUom());
            entity.setQuantity(bottle.getQuantity());
            entity.setQuantityUom(bottle.getQuantityUom());
            entity.setVitamin(bottle.isVitamin());
            entity.setNote(bottle.getNote());

            bottles.add(entity);
        }

        return bottles;
    }

    private static ZonedDateTime buildZDT(FeedRequest request) {
        LocalTime lt = Jbom.buildLocalTime(request.getTimeHour(), request.getTimeMinute(), request.getMeridiem());
        LocalDateTime ldt = LocalDateTime.of(Jbom.convertDate(request.getDate()), lt);
        ZonedDateTime zdt = ZonedDateTime.of(ldt, ZoneId.of("America/New_York"));

        return zdt;
    }

    private static String buildDate(ZonedDateTime zdt) {
        StringBuilder sb = new StringBuilder();
        sb.append(zdt.getMonthValue());
        sb.append("/");
        sb.append(zdt.getDayOfMonth());
        sb.append("/");
        sb.append(zdt.getYear());

        return sb.toString();
    }
}
