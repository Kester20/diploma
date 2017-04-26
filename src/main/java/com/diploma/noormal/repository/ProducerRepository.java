package com.diploma.noormal.repository;

import com.diploma.noormal.model.Producer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Arsalan. Created on 14.04.2017.
 */
@Repository
public interface ProducerRepository extends CrudRepository<Producer, Long> {
}
