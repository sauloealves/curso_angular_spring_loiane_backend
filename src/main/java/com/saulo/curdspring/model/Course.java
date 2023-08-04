package com.saulo.curdspring.model;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity
@Table(name = "cursos")
public class Course {
    
    @Id
    @GeneratedValue()
    @JsonProperty("_id")
    private Long id;

    @Column(length = 100, nullable = false) 
    @NotNull
    @NotBlank
    @Length(min = 5, max = 100)
    private String name;

    @NotNull
    @NotBlank
    @Length(max = 10)
    @Pattern(regexp = "Back-end|Front-end")
    @Column(length = 10, nullable = false)
    private String category;
}
