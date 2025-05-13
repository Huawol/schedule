package com.scheduler.service;

import com.scheduler.dto.ScheduleRequestDto;
import com.scheduler.dto.ScheduleResponseDto;
import com.scheduler.entity.Schedule;
import com.scheduler.repository.ScheduleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService{

    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }
    @Override // 일정 추가 서비스
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto requestDto) {
        Schedule schedule = new Schedule(requestDto.getTitle(), requestDto.getContents(), requestDto.getAuthor(), requestDto.getPassword());
        ScheduleResponseDto saveSchedule = scheduleRepository.saveSchedule(schedule);
        return saveSchedule;
    }

    @Override // 스케줄 전체 조회
    public List<ScheduleResponseDto> findAllSchedule(String name, LocalDate date) {
        List<ScheduleResponseDto> allSchedule = scheduleRepository.findAllSchedule(name, date);
        return allSchedule;
    }

    @Override
    public ScheduleResponseDto findScheduleById(Long id) {
        return scheduleRepository.findScheduleByIdOrElseThrow(id);
//        ScheduleResponseDto scheduleResponseDto = scheduleRepository.findScheduleByIdOrElseThrow(id);
//        return scheduleResponseDto; 위에거랑 같은거
    }

    @Override
    public ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto requestDto) {

        Schedule schedule = scheduleRepository.findScheduleByIdOrElseThrowV2(id);
        if (schedule == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }
        if (requestDto.getPassword() == null) { // 비번이 입력값이 있는지 없는지
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The title and content are required values.");
        }
        if (!schedule.getPassword().equals(requestDto.getPassword())) { // 비번 확인
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "비번 틀렸어!");
        }

        // 제목 내용 작성자 있는지 없는지
        if (requestDto.getTitle() == null || requestDto.getContents() == null || requestDto.getAuthor() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The title and content are required values.");
        }
        scheduleRepository.updateSchedule(id, requestDto); // 수정
        return scheduleRepository.findScheduleByIdOrElseThrow(id); // 조회
    }

    @Override
    public void deleteSchedule(Long id, ScheduleRequestDto requestDto) {
        Schedule schedule = scheduleRepository.findScheduleByIdOrElseThrowV2(id);
        if (schedule == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }
        if (schedule.getPassword() == null) { // 비번이 입력값이 있는지 없는지
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The title and content are required values.");
        }
        if (!schedule.getPassword().equals(requestDto.getPassword())) { // 비번 확인
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "비번 틀렸어!");
        }
        scheduleRepository.deleteSchedule(id, requestDto);
    }
}
