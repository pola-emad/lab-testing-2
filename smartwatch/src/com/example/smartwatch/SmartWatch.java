package com.example.smartwatch;

import java.time.LocalDateTime;

public class SmartWatch {

    enum OuterState {
        NormalDisplay,
        ChimeAlarmSet,
        Update
    }
    enum InnerState {
        Time,
        Date,
        Alarm,
        Chime,
        min,
        hour,
        day,
        month,
        year
    }

    private OuterState outerstate;
    private InnerState innerstate;
    private LocalDateTime watchDateTime;

    SmartWatch(){
        watchDateTime = LocalDateTime.now();
        outerstate = OuterState.NormalDisplay;
        innerstate = InnerState.Time;
    }
    private void toggle_display() {
        innerstate = innerstate==InnerState.Date? InnerState.Time : InnerState.Date;
    }

    private void SetOuterState(OuterState new_state) {
        if(new_state == OuterState.NormalDisplay) {
            outerstate = OuterState.NormalDisplay;
            innerstate = InnerState.Time;
        }else if(new_state == OuterState.ChimeAlarmSet) {
            outerstate = OuterState.ChimeAlarmSet;
            innerstate = InnerState.Alarm;
        }else {
            outerstate = OuterState.Update;
            innerstate = InnerState.min;
        }
    }

    private void NormalDisplay_input(char button) {
        if(button== 'a') {
            toggle_display();
        }else if(button == 'b') {
            SetOuterState(OuterState.ChimeAlarmSet);
        }else if(button == 'c') {
            SetOuterState(OuterState.Update);
        }
    }
    private void ChimeAlarmSet_input(char button) {
        if(button == 'a' && innerstate== InnerState.Alarm) {
            innerstate = InnerState.Chime;
        }
        else if(button == 'd') {
            SetOuterState(OuterState.NormalDisplay);
        }
    }
    private void Update_input(char button) {
        if(button == 'a' && innerstate == InnerState.min ) {
            innerstate = InnerState.hour;
        }
        else if(button == 'a' && innerstate == InnerState.hour ) {
            innerstate = InnerState.day;
        }
        else if(button == 'a' && innerstate == InnerState.day ) {
            innerstate = InnerState.month;
        }
        else if(button == 'a' && innerstate == InnerState.month ) {
            innerstate = InnerState.year;
        }
        else if(button == 'a' && innerstate == InnerState.year ) {
            SetOuterState(OuterState.NormalDisplay);
        }
        else if(button == 'b' && innerstate == InnerState.min ) {
            watchDateTime = watchDateTime.plusMinutes(1);
        }
        else if(button == 'b' && innerstate == InnerState.hour ) {
            watchDateTime = watchDateTime.plusHours(1);
        }
        else if(button == 'b' && innerstate == InnerState.day ) {
            watchDateTime = watchDateTime.plusDays(1);
        }
        else if(button == 'b' && innerstate == InnerState.month ) {
            watchDateTime = watchDateTime.plusMonths(1);
        }
        else if(button == 'b' && innerstate == InnerState.year ) {
            watchDateTime = watchDateTime.plusYears(1);
        }
        else if(button == 'd') {
            SetOuterState(OuterState.NormalDisplay);
        }
    }

    public void take_input(char button){
        if (outerstate==OuterState.NormalDisplay) {
            NormalDisplay_input(button);
        }else if(outerstate==OuterState.ChimeAlarmSet) {
            ChimeAlarmSet_input(button);
        }else {
            Update_input(button);
        }
    }

    public LocalDateTime get_date_time() {
        return watchDateTime;
    }

    public OuterState get_OuterState() {
        return outerstate;
    }

    public InnerState get_InnerState() {
        return innerstate;
    }

}
