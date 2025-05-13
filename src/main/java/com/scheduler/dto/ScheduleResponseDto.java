package com.scheduler.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.scheduler.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {

    private Long id;
    private String title;
    private String contents;
    private String author;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") // 날짜 출력 형태 변경
    private LocalDateTime createtime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime updatetime;


    // postman에 나오는것들
    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.author = schedule.getAuthor();
        this.createtime = schedule.getCreatedAt();
        this.updatetime = schedule.getUpdatedAt();
    }
}
