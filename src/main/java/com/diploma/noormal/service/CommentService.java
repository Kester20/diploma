package com.diploma.noormal.service;

import com.diploma.noormal.model.Comment;
import com.diploma.noormal.model.Product;
import com.diploma.noormal.model.User;

import java.util.List;

/**
 * @author Arsalan. Created on 10.05.2017.
 */
public interface CommentService {

    void addComment(User user, Product product, String text);

    List<Comment> findCommentsByUser(Long userId);

    List<Comment> findPublishedCommentsByProduct(Long productId);
}
