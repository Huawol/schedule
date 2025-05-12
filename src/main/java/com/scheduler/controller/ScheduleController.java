package com.scheduler.controller;

import com.scheduler.dto.ScheduleRequestDto;
import com.scheduler.dto.ScheduleResponseDto;
import com.scheduler.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }


    @PostMapping // 스케쥴 작성
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto requestDto) {

        return new ResponseEntity<>(scheduleService.saveSchedule(requestDto), HttpStatus.CREATED);
    }

    @GetMapping // 전체 조회
    public List<ScheduleResponseDto> findAllSchedule() {
        return scheduleService.findAllSchedule();
    }

    @GetMapping("/{id}") // 단건 조회
    public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable Long id) {
        return new ResponseEntity<>(scheduleService.findScheduleById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}") // 수정
    public ResponseEntity<ScheduleResponseDto> updateSchedule(
            @PathVariable Long id,
            @RequestBody ScheduleRequestDto responseDto
    ) {
        return new ResponseEntity<>(scheduleService.updateSchedule(id,
                responseDto.getTitle(),responseDto.getContents()), HttpStatus.OK);
    }

    @DeleteMapping("/{id}") // 삭제
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
