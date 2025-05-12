package com.scheduler.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Schedule {

    @Setter
    private Long id;
    private String title;
    private String contents;
    private String author;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public Schedule(String title, String contents, String author) {
        this.title = title;
        this.contents = contents;
        this.author = author;
        this.createdAt = LocalDateTime.now();
    }

    public void update(String title, String contents) {
        this.title = title;
        this.contents = contents;
        this.updatedAt = LocalDateTime.now();
    }
}
