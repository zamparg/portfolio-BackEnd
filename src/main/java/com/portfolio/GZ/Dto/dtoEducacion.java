package com.portfolio.GZ.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class dtoEducacion {
    
    @NotBlank
    private String time;
    @NotBlank
    private String tittle;
    @NotBlank
    private String academy;

    
    //Constructor

    public dtoEducacion() {
    }

    public dtoEducacion( String time, String tittle,String academy) {
        
        this.time = time;
        this.tittle = tittle;
        this.academy = academy;

    }
   
    
    
}
