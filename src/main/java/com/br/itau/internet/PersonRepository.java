package com.br.itau.internet;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * Created by luismoro on 12/12/16.
 */
interface PersonRepository extends ReactiveCrudRepository<Person, String> {

}
