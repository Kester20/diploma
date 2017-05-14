package com.diploma.noormal.repository;

import com.diploma.noormal.model.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.diploma.noormal.util.Constants.ControllerConstants.ID_PRODUCT;

/**
 * @author Arsalan. Created on 09.05.2017.
 */
@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {

    List<Comment> findByUserId(Long userId);

    @Query("SELECT c FROM Comment c WHERE c.product.id = :idProduct AND c.status = 'PUBLISHED'")
    List<Comment> findPublishedCommentsByProductId(@Param(ID_PRODUCT) Long idProduct);
}
