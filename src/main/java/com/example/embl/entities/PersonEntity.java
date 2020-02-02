package com.example.embl.entities;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "Person")
@Data
@Table(name = "PERSON")
//@IdClass(PersonId.class)
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    //@Id
    @Column(name = "FIRST_NAME")
    private String firstName;

    //@Id
    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "AGE")
    private int age;

    @Column(name = "FAVOURITE_COLOR")
    private String favouriteColor;

    @Column(name = "Hobbies")
    private String likedHobbies;

}
