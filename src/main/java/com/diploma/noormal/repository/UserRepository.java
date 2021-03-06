package com.diploma.noormal.repository;

import com.diploma.noormal.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Arsalan. Created on 14.04.2017.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
