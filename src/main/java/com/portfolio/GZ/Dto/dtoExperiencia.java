package com.portfolio.GZ.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class dtoExperiencia {
    @NotBlank
    private String employer;
    @NotBlank
    private String img;
    @NotBlank
    private String role;
    @NotBlank
    private String duration;
    @NotBlank
    private String task;
    
    //Constructor

    public dtoExperiencia() {
    }

    public dtoExperiencia(String employer, String img, String role, String duration, String task) {

        this.employer = employer;
        this.img = img;
        this.role = role;
        this.duration = duration;
        this.task = task;
    }
   
    
    
}
