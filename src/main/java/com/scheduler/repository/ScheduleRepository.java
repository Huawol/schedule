package com.scheduler.repository;

import com.scheduler.dto.ScheduleRequestDto;
import com.scheduler.dto.ScheduleResponseDto;
import com.scheduler.entity.Schedule;

import java.util.List;

public interface ScheduleRepository {
    ScheduleResponseDto saveSchedule(Schedule schedule);
    List<ScheduleResponseDto> findAllSchedule();
    ScheduleResponseDto findScheduleByIdOrElseThrow(Long id);
    Schedule findScheduleByIdOrElseThrowV2(Long id);
    int updateSchedule(Long id, ScheduleRequestDto scheduleRequestDto);
    int deleteSchedule(Long id, ScheduleRequestDto dto);
}
