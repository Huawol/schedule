package com.scheduler.repository;

import com.scheduler.dto.ScheduleRequestDto;
import com.scheduler.dto.ScheduleResponseDto;
import com.scheduler.entity.Schedule;

public interface ScheduleRepository {
    Schedule saveSchedule(Schedule schedule);
}
