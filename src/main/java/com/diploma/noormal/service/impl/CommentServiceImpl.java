package com.diploma.noormal.service.impl;

import com.diploma.noormal.model.Comment;
import com.diploma.noormal.model.CommentStatus;
import com.diploma.noormal.model.Product;
import com.diploma.noormal.model.User;
import com.diploma.noormal.repository.CommentRepository;
import com.diploma.noormal.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Arsalan. Created on 10.05.2017.
 */
@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void addComment(User user, Product product, String text) {
        Comment comment = new Comment();
        comment.setProduct(product);
        comment.setUser(user);
        comment.setText(text);
        comment.setStatus(CommentStatus.NOT_PUBLISHED);
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> findCommentsByUser(Long userId) {
        return commentRepository.findByUserId(userId);
    }

    @Override
    public List<Comment> findPublishedCommentsByProduct(Long idProduct) {
        return commentRepository.findPublishedCommentsByProductId(idProduct);
    }
}
