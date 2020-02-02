package com.example.embl.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class Person {

    @NotNull
    private int id;
    @NotEmpty(message = "First name must not be empty")
    private String first_name;
    @NotNull
    private String last_name;
    @NotNull
    private int age;
    @NotNull
    private String favorite_colour;
    @NotNull
    private List<String> hobby;
}
