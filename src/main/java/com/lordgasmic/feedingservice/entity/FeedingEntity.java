package com.lordgasmic.feedingservice.entity;

import com.lordgasmic.feedingservice.model.UnitOfMeasure;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.ZonedDateTime;

@Entity(name = "feed_vw")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedingEntity {

    @Id
    private ZonedDateTime timestmp;
    private int given;
    private UnitOfMeasure givenUom;
    private int quantity;
    private UnitOfMeasure quantityUom;
    private boolean vitamin;
    private String note;
}
