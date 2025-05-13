package com.scheduler.service;

import com.scheduler.dto.ScheduleRequestDto;
import com.scheduler.dto.ScheduleResponseDto;

import java.time.LocalDate;
import java.util.List;


public interface ScheduleService {

    ScheduleResponseDto saveSchedule(ScheduleRequestDto requestDto);
    List<ScheduleResponseDto> findAllSchedule(String name, LocalDate date);
    ScheduleResponseDto findScheduleById(Long id);
    ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto requestDto);
    void deleteSchedule(Long id, ScheduleRequestDto scheduleRequestDto);
}
