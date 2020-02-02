package com.example.embl.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class PersonRequest {

    @NotNull
    List<Person> person;


}
