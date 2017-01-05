package com.br;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by luismoro on 12/12/16.
 */
@Component
class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Flux<Person> all() {
        return personRepository.findAll();
    }

    public Mono<Person> byId(String id) {
        return personRepository.findOne(id);
    }

    public Mono<Person> save(Person person) {
        return personRepository.save(person);
    }

    public Mono<Person> save(String id, Person person) {
        Person p = new Person(id, person.getName(), person.getAge());

        return personRepository.save(p);
    }

    public Mono<Person> justSave(String id, Person person) {
        //TODO Precisa refatorar para deixar de ser bloqueante
        System.out.println("Need Refactor!!!");
        Mono<Person> mono = personRepository.findOne(id);

       return  mono
                .map(p -> new Person(id, person.getName(), person.getAge(), p))
                .map(personRepository::save)
                .block();
    }
}
