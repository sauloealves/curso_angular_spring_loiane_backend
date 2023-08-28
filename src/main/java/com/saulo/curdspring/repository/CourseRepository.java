package com.saulo.curdspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.saulo.curdspring.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long > {
    
}
