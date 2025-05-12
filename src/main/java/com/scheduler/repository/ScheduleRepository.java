package com.scheduler.repository;

import com.scheduler.dto.ScheduleRequestDto;
import com.scheduler.dto.ScheduleResponseDto;
import com.scheduler.entity.Schedule;

import java.util.List;

public interface ScheduleRepository {
    Schedule saveSchedule(Schedule schedule);
    List<ScheduleResponseDto> findAllSchedule();
    Schedule findScheduleById(Long id);
}
