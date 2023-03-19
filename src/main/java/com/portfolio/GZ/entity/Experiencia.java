package com.portfolio.GZ.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Experiencia {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    private String employer;
    
    @NotNull
    private String img;

    @NotNull
    private String role;
    
    @NotNull
    private String duration;
    
   
    private String task;

    
    //Constructores
    public Experiencia() {
    }

    public Experiencia( String employer, String img, String role, String duration, String task) {
        
        this.employer = employer;
        this.img = img;
        this.role = role;
        this.duration = duration;
        this.task = task;
    }
    
    //Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
    
    
    
}
