package com.example.embl.service;

import com.example.embl.request.PersonRequest;
import com.example.embl.response.PersonResponse;

public interface PersonService {

    void savePerson(PersonRequest person);

    PersonResponse getAllPerson();

    PersonResponse getPersonById(int id);

    void deletePerson(int id);


}
