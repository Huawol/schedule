package com.scheduler.dto;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
public class ScheduleRequestDto {

    private String title;
    private String author;
    private String contents;
}
