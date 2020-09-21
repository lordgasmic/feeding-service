package com.lordgasmic.feedingservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BottleEntityPK implements Serializable {

    private ZonedDateTime timestmp;
    private int ordinal;
}