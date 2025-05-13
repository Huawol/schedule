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
    @Setter
    private String password;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public Schedule(String title, String contents, String author, String password) {
        this.title = title;
        this.contents = contents;
        this.author = author;
        this.password = password;
        this.createdAt = LocalDateTime.now();
    }
}
