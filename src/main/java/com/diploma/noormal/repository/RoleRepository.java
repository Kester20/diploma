package com.diploma.noormal.repository;

import com.diploma.noormal.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Arsalan. Created on 14.04.2017.
 */
@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}
