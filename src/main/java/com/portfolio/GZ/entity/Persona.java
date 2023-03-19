package com.portfolio.GZ.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String name;

    @NotNull
    @Size(min = 1, max = 300, message = "No cumple con la longitud")
    private String description;

    @NotNull
    @Size(min = 1, max = 500, message = "No cumple con la longitud")
    private String about;

    @NotNull
    @Size(min = 1, max = 400, message = "No cumple con la longitud")
    private String img;

}
