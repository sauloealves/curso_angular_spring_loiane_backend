package com.saulo.curdspring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.saulo.curdspring.exception.RecordNotFoundException;
import com.saulo.curdspring.model.Course;
import com.saulo.curdspring.repository.CourseRepository;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class CourseService {

    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    
    public List<Course> list() {
        return courseRepository.findAll();
    }

    public Course getById( @NotNull @Positive Long id){

        return this.courseRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id));
    }

    public Course create(@Valid Course course) {
        return this.courseRepository.save(course);
    }

    public Course update(  @NotNull @Positive Long id, @Valid Course course){
        return courseRepository.findById(id)
        .map(recordFound -> {
            recordFound.setName((course.getName()));
            recordFound.setCategory(course.getCategory());
            return courseRepository.save(recordFound);
        }).orElseThrow(() -> new RecordNotFoundException(id));        
    }

    public void delete(@NotNull @Positive Long id){
        courseRepository.delete(courseRepository.findById(id).orElseThrow(() -> new RecordNotFoundException(id)));
    }

}
