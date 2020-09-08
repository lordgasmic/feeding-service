package com.lordgasmic.feedingservice.utils;

import com.lordgasmic.feedingservice.model.Meridiem;
import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

public class JbomTest {

    @Test
    public void test24Hour_Midnight() {
        LocalTime expected = LocalTime.of(0,0);
        LocalTime actual = Jbom.buildLocalTime(12, 0, Meridiem.am);
        assertEquals(expected, actual);
    }

    @Test
    public void test24Hour_1Am() {
        LocalTime expected = LocalTime.of(1,0);
        LocalTime actual = Jbom.buildLocalTime(1, 0, Meridiem.am);
        assertEquals(expected, actual);
    }

    @Test
    public void test24Hour_Noon() {
        LocalTime expected = LocalTime.of(12,0);
        LocalTime actual = Jbom.buildLocalTime(12, 0, Meridiem.pm);
        assertEquals(expected, actual);
    }

    @Test
    public void test24Hour_1Pm() {
        LocalTime expected = LocalTime.of(13,0);
        LocalTime actual = Jbom.buildLocalTime(1, 0, Meridiem.pm);
        assertEquals(expected, actual);
    }
}