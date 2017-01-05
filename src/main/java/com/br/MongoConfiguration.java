package com.br;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * @author Sebastien Deleuze
 * @author Mark Paluch
 */
@Configuration
@EnableReactiveMongoRepositories
public class MongoConfiguration extends AbstractReactiveMongoConfiguration {

    @Value("${mongo.database}")
    private String database;

    @Bean
    ObjectMapper objectMapper() {
        return Jackson2ObjectMapperBuilder.json().build();
    }

    @Override
    public MongoClient mongoClient() {
        return MongoClients.create();
    }

    @Override
    protected String getDatabaseName() {
        return database;
    }

//    @Bean
//    CommandLineRunner initData(PersonRepository personRepository) {
//        return (p) -> {
//            personRepository.deleteAll().block();
//            personRepository.save(new Person("1", "Eric", "Foo")).block();
//            personRepository.save(new Person("2", "Raymond", "Bar")).block();
//            personRepository.save(new Person("3", "Paul", "Baz")).block();
//        };
//    }

}
