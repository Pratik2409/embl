package com.example.embl.controller;

import com.example.embl.request.PersonRequest;
import com.example.embl.response.PersonResponse;
import com.example.embl.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@CrossOrigin("*")
@Api(tags = "Person Controller")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("v1/persons")
    @ApiOperation(value = "Retrieve all person details")
    public ResponseEntity<PersonResponse> persons() {
        return ResponseEntity.ok(personService.getAllPerson());
    }

    @GetMapping("v1/persons/{id}")
    @ApiOperation(value = "Retrieve one person details")
    public ResponseEntity<PersonResponse> getPerson(@NotNull @PathVariable int id) {
        return ResponseEntity.ok(personService.getPersonById(id));
    }


    @PostMapping("v1/person")
    @ApiOperation(value = "store person details")
    public ResponseEntity addPerson(@Valid @RequestBody PersonRequest person) {
        personService.savePerson(person);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PutMapping("v1/person")
    @ApiOperation(value = "update person details")
    public ResponseEntity updatePerson(@Valid @RequestBody PersonRequest person) {
        personService.savePerson(person);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("v1/person/{id}")
    @ApiOperation(value = "Delete person details")
    public ResponseEntity deletePerson(@NotNull @PathVariable int id) {
        personService.deletePerson(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
