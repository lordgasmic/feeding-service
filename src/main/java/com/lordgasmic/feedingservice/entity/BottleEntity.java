package com.lordgasmic.feedingservice.entity;

import com.lordgasmic.feedingservice.model.UnitOfMeasure;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name = "bottle_vw")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BottleEntity {

    @EmbeddedId
    private BottleEntityPK pk;
    private int given;
    private UnitOfMeasure givenUom;
    private int quantity;
    private UnitOfMeasure quantityUom;
    private boolean vitamin;
    private boolean probiotic;
    private boolean gas;
    private String note;
}