package com.saulo.curdspring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saulo.curdspring.model.Course;
import com.saulo.curdspring.repository.CourseRepository;
import com.saulo.curdspring.service.CourseService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import org.springframework.web.bind.annotation.ResponseStatus;

@Validated
@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService service) {
        this.courseService = service;
    }

    @GetMapping
    public List<Course> list() {
        return courseService.list();
    }

    // @RequestMapping(method=RequestMethod.POST)
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Course create(@RequestBody @Valid Course course) {
        return courseService.create(course);
    }
    // PODE SER DA FORMA ABAIXO
    /*
    // @RequestMapping(method=RequestMethod.POST)
    @PostMapping
    public ResponseEntity<Course> create(@RequestBody Course course) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(courseRepository.save(course));
    } */    

    @GetMapping("/{id}")
    public Course getById(@PathVariable @NotNull @Positive Long id){
        return courseService.getById(id);
    }

    @PutMapping("/{id}")
    public Course update(@PathVariable  @NotNull @Positive Long id, @RequestBody @Valid Course course){
        return courseService.update(id, course);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable  @NotNull @Positive Long id){
        courseService.delete(id);
    }


}
