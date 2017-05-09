package com.diploma.noormal.repository;

import com.diploma.noormal.model.Comment;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Arsalan. Created on 09.05.2017.
 */
public interface CommentRepository extends CrudRepository<Comment, Long> {
}
