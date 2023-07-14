package com.saulo.curdspring.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cursos")
public class Course {
    
    @Id
    @GeneratedValue()
    @JsonProperty("_id")
    private Long id;

    @Column(length = 200, nullable = false)    
    private String name;

    @Column(length = 10, nullable = false)
    private String category;
}
