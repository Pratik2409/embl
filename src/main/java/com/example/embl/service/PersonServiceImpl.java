package com.example.embl.service;

import com.example.embl.entities.PersonEntity;
import com.example.embl.repositories.PersonRepository;
import com.example.embl.request.Person;
import com.example.embl.request.PersonRequest;
import com.example.embl.response.PersonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public void savePerson(PersonRequest personRequest) {

        if (personRequest.getPerson() != null) {

            for (Person person : personRequest.getPerson()) {
                PersonEntity personEntity = new PersonEntity();

                if (person.getFavorite_colour() == null ||
                        person.getHobby() == null || person.getFirst_name() == null ||
                        person.getLast_name() == null) {
                    return;
                }


                personEntity.setId(person.getId());
                personEntity.setAge(person.getAge());
                personEntity.setFavouriteColor(person.getFavorite_colour());
                personEntity.setFirstName(person.getFirst_name());
                personEntity.setLastName(person.getLast_name());
                personEntity.setLikedHobbies(String.join(",", person.getHobby()));
                personRepository.save(personEntity);
            }
        }
    }

    @Override
    public PersonResponse getAllPerson() {

        PersonResponse personResponse = new PersonResponse();
        List<Person> personList = new ArrayList<>();
        for (PersonEntity personEntity : personRepository.findAll()) {
            Person person = new Person();
            person.setId(personEntity.getId());
            person.setAge(personEntity.getAge());
            person.setFavorite_colour(personEntity.getFavouriteColor());
            person.setFirst_name(personEntity.getFirstName());
            person.setLast_name(personEntity.getLastName());
            person.setHobby(Arrays.asList(personEntity.getLikedHobbies().split(",")));
            personList.add(person);
        }
        personResponse.setPerson(personList);
        return personResponse;
    }

    @Override
    public PersonResponse getPersonById(int id) {

        List<Person> personList = new ArrayList<>();
        PersonResponse personResponse = new PersonResponse();
        PersonEntity personEntity = personRepository.getPersonById(id);
        Person person = new Person();

        if (personEntity != null) {
            person.setId(personEntity.getId());
            person.setAge(personEntity.getAge());
            person.setFavorite_colour(personEntity.getFavouriteColor());
            person.setFirst_name(personEntity.getFirstName());
            person.setLast_name(personEntity.getLastName());
            person.setHobby(Arrays.asList(personEntity.getLikedHobbies().split(",")));
            personList.add(person);
        }
        personResponse.setPerson(personList);
        return personResponse;
    }

    //@Override
    /*public PersonResponse getPersonByName(String firstName, String lastName) {

        List<Person> personList = new ArrayList<>();
        PersonResponse personResponse = new PersonResponse();

        //PersonEntity personEntity = personRepository.getPersonByFirstNameAndLastName(firstName, lastName);
        PersonEntity personEntity = personRepository.getPersonById(id);
        Person person = new Person();
        person.setAge(personEntity.getAge());
        person.setFavorite_colour(personEntity.getFavouriteColor());
        person.setFirst_name(personEntity.getFirstName());
        person.setLast_name(personEntity.getLastName());
        person.setHobby(Arrays.asList(personEntity.getLikedHobbies().split(",")));
        personList.add(person);

        personResponse.setPerson(personList);
        return personResponse;
    }*/

    @Override
    public void deletePerson(int id) {
        personRepository.deleteById(id);
    }
}
