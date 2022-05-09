package com.example.smartwatch;

import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

public class SmartWatchTest {

    void parse_string(String input,SmartWatch watch) {
        for(int i=0;i<input.length();i++) {
            watch.take_input(input.charAt(i));
        }
    }


    @Test
    void StateCoverage() {
        SmartWatch watch = new SmartWatch();
        LocalDateTime date_before_actions = watch.get_date_time();
        parse_string("abadcaaaaa",watch);
        boolean equal_dates = date_before_actions.equals(watch.get_date_time());
        assertTrue(equal_dates && watch.get_InnerState() == SmartWatch.InnerState.Time && watch.get_OuterState() == SmartWatch.OuterState.NormalDisplay);
    }

    @Test
    void EdgeCoverage() {
        // edge coverage
        SmartWatch watch = new SmartWatch();
        LocalDateTime date_before_actions = watch.get_date_time();
        parse_string("aabadcbababababacd",watch);
        boolean equal_dates = date_before_actions.plusMinutes(1).plusHours(1).plusDays(1).plusMonths(1).plusYears(1).equals(watch.get_date_time());
        assertTrue(equal_dates && watch.get_InnerState() == SmartWatch.InnerState.Time && watch.get_OuterState() == SmartWatch.OuterState.NormalDisplay);
    }

    @Test
    void ADUPCoverage1() {
        // ADUP on min
        SmartWatch watch = new SmartWatch();
        LocalDateTime date_before_actions = watch.get_date_time();
        parse_string("cbaaaaaa",watch);
        boolean equal_dates = date_before_actions.plusMinutes(1).equals(watch.get_date_time());
        assertTrue(equal_dates && watch.get_InnerState() == SmartWatch.InnerState.Date && watch.get_OuterState() == SmartWatch.OuterState.NormalDisplay);
    }

    @Test
    void ADUPCoverage2() {
        // ADUP on hour
        SmartWatch watch = new SmartWatch();
        LocalDateTime date_before_actions = watch.get_date_time();
        parse_string("cabaaaaac",watch);
        boolean equal_dates = date_before_actions.plusHours(1).equals(watch.get_date_time());
        assertTrue(equal_dates && watch.get_InnerState() == SmartWatch.InnerState.min && watch.get_OuterState() == SmartWatch.OuterState.Update);
    }



    @Test
    void ADUPCoverage3() {
        // ADUP on day
        SmartWatch watch = new SmartWatch();
        LocalDateTime date_before_actions = watch.get_date_time();
        parse_string("caabaaaaca",watch);
        boolean equal_dates = date_before_actions.plusDays(1).equals(watch.get_date_time());
        assertTrue(equal_dates && watch.get_InnerState() == SmartWatch.InnerState.hour && watch.get_OuterState() == SmartWatch.OuterState.Update);
    }

    @Test
    void ADUPCoverage4() {
        // ADUP on month
        SmartWatch watch = new SmartWatch();
        LocalDateTime date_before_actions = watch.get_date_time();
        parse_string("caaabaaacaa",watch);
        boolean equal_dates = date_before_actions.plusMonths(1).equals(watch.get_date_time());
        assertTrue(equal_dates && watch.get_InnerState() == SmartWatch.InnerState.day && watch.get_OuterState() == SmartWatch.OuterState.Update);
    }

    @Test
    void ADUPCoverage5() {
        // ADUP on year
        SmartWatch watch = new SmartWatch();
        LocalDateTime date_before_actions = watch.get_date_time();
        parse_string("caaaabaacaaa",watch);
        boolean equal_dates = date_before_actions.plusYears(1).equals(watch.get_date_time());
        assertTrue(equal_dates && watch.get_InnerState() == SmartWatch.InnerState.month && watch.get_OuterState() == SmartWatch.OuterState.Update);
    }


}
