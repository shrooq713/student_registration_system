package com.college.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getCourses(){
        return courseRepository.findAll();
    }
    public Course getCourse(String id){
        return courseRepository.findById(id).orElse(null);
    }

    public Course addCourse(Course course){
        return courseRepository.save(course);
    }

    public String updateCourse(String id, Course data) {
        Course course= courseRepository.findById(id).orElse(null);
        if(course != null){
            course.setName(data.getName());
            course.setStart_time(data.getStart_time());
            course.setEnd_time(data.getEnd_time());
            course.setDay(data.getDay());
            course.setFinal_exam_date(data.getFinal_exam_date());
            course.setHours(data.getHours());
            courseRepository.save(course);
        }
        return "updated";
    }
    public String deleteCourse(String id) {
        courseRepository.deleteById(id);
        return "deleted";
    }
}
