package com.kish.learning.resource;


import com.kish.learning.resource.model.Person;
import com.kish.learning.resource.service.PersonService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/hello")
public class GreetingsResource {

    @Inject
    PersonService personService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
//    @Transactional
    public String hello() {
        return "hello\n";
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/persons")
    @RolesAllowed("user")
    @Transactional
    public Person createData(Person person){
        Person person1 = new Person();
        person1.name = person.name;
        person1.birth = person.birth;
        person1.status = person.status;

        // persist it
        person1.persist();
        return person;
    }

    @DELETE
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/persons/{name}")
    @Transactional
    public long deleteData(String name){
        return Person.deleteByName(name);
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/persons")
    public List<Person> getAllPerson(){
        return personService.findAll().list();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/persons/{name}")
    public Person getPerson(@PathParam("name") String name){
        return personService.findByName(name);
    }

}
