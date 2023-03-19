package com.portfolio.GZ.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class dtoSkills {
    @NotBlank
    private String img;
    @NotBlank
    private String tittle;
    @NotBlank
    private int percent;

    public dtoSkills() {
    }

    public dtoSkills(String img, String tittle, int percent) {
        this.img = img;
        this.tittle = tittle;
        this.percent = percent;
    }
    
    
    
    
}
