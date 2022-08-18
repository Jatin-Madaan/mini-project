package com.miniproject.controller;

import com.miniproject.entity.Course;
import com.miniproject.entity.Student;
import com.miniproject.repository.CourseRepository;
import com.miniproject.repository.StudentRepository;
import io.micronaut.http.annotation.*;

import java.util.List;

@Controller("/student/course")
public class StudentCourseController {

    private StudentRepository studentRepository;

    private CourseRepository courseRepository;

    public StudentCourseController(StudentRepository studentRepository,
                                   CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Post
    public Student saveStudentWithCourse(@Body Student student){
        return  studentRepository.save(student);
    }

    @Get
    public List<Student> findALlStudents(){
        return studentRepository.findAll();
    }

    @Get("/{studentId}")
    public Student findStudent(@PathVariable Long studentId){
        return studentRepository.findById(studentId).orElse(null);
    }
    @Get("/find/{name}")
    public List<Student> findStudentsContainingByName(@PathVariable String name){
        return studentRepository.findByNameContaining(name);
    }

    @Get("/search/{price}")
    public List<Course> findCourseLessThanPrice(@PathVariable double price){
        return courseRepository.findByFeeLessThan(price);
    }

}
