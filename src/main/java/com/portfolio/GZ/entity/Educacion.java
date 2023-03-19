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
public class Educacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull

    private String time;

    @NotNull

    private String tittle;

    @NotNull

    private String academy;

    public Educacion() {
    }

    public Educacion(String time, String tittle, String academy) {

        this.time = time;
        this.tittle = tittle;
        this.academy = academy;
    }
    
    
}
