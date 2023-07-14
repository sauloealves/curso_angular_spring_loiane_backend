package com.saulo.curdspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.saulo.curdspring.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long > {
    
}
