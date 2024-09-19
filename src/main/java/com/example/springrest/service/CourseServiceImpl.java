package com.example.springrest.service;

import com.example.springrest.dao.CourseDao;
import com.example.springrest.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseDao courseDao;

//    List<Course> list;

    public CourseServiceImpl(){
//        list = new ArrayList<>();
//        list.add(new Course(1, "Java", "Basics of java"));
//        list.add(new Course(2, "Python", "Basics of python"));
//        list.add(new Course(3, "MySQL", "Basics of mysql"));
    }

    @Override
    public List<Course> getCourses(){
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long courseId) {

//        Course c = null;
//        for (Course course:list) {
//
//            if(course.getId()==courseId){
//                c=course;
//                break;
//            }
//
//        }
        return courseDao.getOne(courseId);
    }

    @Override
    public Course addCourse(Course course) {
//        list.add(course);
        courseDao.save(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
//        list.forEach(e -> {
//            if(e.getId() == course.getId()){
//                e.setTitle(course.getTitle());
//                e.setDescription(course.getDescription());
//            }
//        });

        courseDao.save(course);
        return course;
    }

    @Override
    public void deleteCourse(long courseId) {
//        list = this.list.stream().filter(e->e.getId()!=courseId).collect(Collectors.toList());
        Course entity = courseDao.getOne(courseId);
        courseDao.delete(entity);
    }

}
