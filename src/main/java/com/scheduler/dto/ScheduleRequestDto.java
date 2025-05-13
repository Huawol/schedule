package com.scheduler.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
public class ScheduleRequestDto {

    private String title;
    private String author;
    private String contents;
    @Setter
    private String password;
}
