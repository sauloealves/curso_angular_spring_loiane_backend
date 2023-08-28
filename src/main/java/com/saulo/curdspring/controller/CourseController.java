package com.saulo.curdspring.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.saulo.curdspring.dto.CourseDTO;
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
    public List<CourseDTO> list() {
        return courseService.list();
    }

    // @RequestMapping(method=RequestMethod.POST)
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CourseDTO create(@RequestBody @Valid CourseDTO course) {
        return courseService.create(course);
    }
    

    @GetMapping("/{id}")
    public CourseDTO getById(@PathVariable @NotNull @Positive Long id){
        return courseService.getById(id);
    }

    @PutMapping("/{id}")
    public CourseDTO update(@PathVariable  @NotNull @Positive Long id, @RequestBody @Valid CourseDTO course){
        return courseService.update(id, course);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable  @NotNull @Positive Long id){
        courseService.delete(id);
    }


}
