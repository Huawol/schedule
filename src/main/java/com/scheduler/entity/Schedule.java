package com.scheduler.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Schedule {

    @Setter
    private Long id;
    private String title;
    private String contents;
    private String author;

    public Schedule(String title, String contents, String author) {
        this.title = title;
        this.contents = contents;
        this.author = author;
    }
}
