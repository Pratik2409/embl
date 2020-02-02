package com.example.embl.response;

import com.example.embl.request.Person;
import lombok.Data;

import java.util.List;

@Data
public class PersonResponse {
    List<Person> person;
}
