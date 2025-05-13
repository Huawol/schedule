//package com.scheduler.repository;
//
//import com.scheduler.dto.ScheduleRequestDto;
//import com.scheduler.dto.ScheduleResponseDto;
//import com.scheduler.entity.Schedule;
//import org.springframework.stereotype.Repository;
//
//import java.util.*;
//
//@Repository
//public class ScheduleRepositoryImpl implements ScheduleRepository{
//
//    private final Map<Long, Schedule> scheduleList = new HashMap<>();
//
//
//    @Override
//    public Schedule saveSchedule(Schedule schedule) {
//        Long scheduleId = scheduleList.isEmpty() ? 1 : Collections.max(scheduleList.keySet()) + 1;
//        schedule.setId(scheduleId);
//        scheduleList.put(scheduleId, schedule);
//        return schedule;
//    }
//
//    @Override
//    public List<ScheduleResponseDto> findAllSchedule() {
//        //init List
//        List<ScheduleResponseDto> allSchedule = new ArrayList<>();
//        for (Schedule schedule : scheduleList.values()) {
//            ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(schedule);
//            allSchedule.add(scheduleResponseDto);
//        }
//        return allSchedule;
//    }
//
//    @Override
//    public Schedule findScheduleById(Long id) {
//        return scheduleList.get(id);
//    }
//
//    @Override
//    public void deleteSchedule(Long id) {
//        scheduleList.remove(id);
//    }
//}
