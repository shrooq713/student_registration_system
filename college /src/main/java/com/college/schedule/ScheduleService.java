package com.college.schedule;

import com.college.course.Course;
import com.college.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    private final ScheduleRepository scheduleRepository;
    @Autowired
    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<Schedule> getSchedules(){
        return scheduleRepository.findAll();
    }
    public Schedule getSchedule(int id){
        return scheduleRepository.findById(id).orElse(null);
    }

    public Schedule addSchedule(Schedule schedule){
        return scheduleRepository.save(schedule);
    }

    public String updateSchedule(int id, Schedule data) {
        Schedule schedule= scheduleRepository.findById(id).orElse(null);
        if(schedule != null){
            schedule.setStart_time(data.getStart_time());
            schedule.setEnd_time(data.getEnd_time());
            scheduleRepository.save(schedule);
        }
        return "updated";
    }
    public String deleteSchedule(int id) {
        scheduleRepository.deleteById(id);
        return "deleted";
    }
}
