package com.college.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "course")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getCourses(){
        return courseService.getCourses();
    }

    //.........................................................
    @GetMapping(path = "/{id}")
    public Course getCourse(@PathVariable String id){
        return courseService.getCourse(id);
    }

    @PostMapping
    public Course addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }
    @PutMapping("/{id}")
    public String updateCourse(@PathVariable String id, @RequestBody Course course){
        return courseService.updateCourse(id, course);
    }

    @DeleteMapping ("/{id}")
    public String deleteCourse(@PathVariable String id){
        return courseService.deleteCourse(id);
    }
}
