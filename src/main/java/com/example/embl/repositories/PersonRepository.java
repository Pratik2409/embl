package com.example.embl.repositories;

import com.example.embl.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, String> {

    //PersonEntity getPersonByFirstNameAndLastName(String firstName, String lastName);

   /* @Transactional
    @Modifying
    @Query("delete from Person p where p.firstName=:firstName and p.lastName=:lastName")
    void deleteByFirstNameAndLastName(String firstName,String lastName);*/

    PersonEntity getPersonById(int id);

    @Transactional
    @Modifying
    void deleteById(int id);


}