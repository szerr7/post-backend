package edu.miu.postbackend.service.impl;


import edu.miu.postbackend.domain.Comment;
import edu.miu.postbackend.dto.CommentDto;
import edu.miu.postbackend.repo.CommentRepository;
import edu.miu.postbackend.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;



    private ModelMapper modelMapper = new ModelMapper()  ;




    @Override
    public List<CommentDto> getAllComments() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream()
                .map(comment -> modelMapper.map(comment, CommentDto.class))
                .collect(Collectors.toList());
    }


    @Override
    public CommentDto getCommentById(long id) {
        Optional<Comment> comment = commentRepository.findById(id) ;
        if (comment.isPresent()){
            return modelMapper.map(comment , CommentDto.class) ;
        }

        else {
            throw new RuntimeException() ;
        }

    }




    @Override
    public void createComment(CommentDto commentDto) {

        Comment comment = modelMapper.map(commentDto, Comment.class);
       commentRepository.save(comment);
    }


    @Override
    public void deleteCommentById(long id) {
        commentRepository.deleteById(id);

    }

    @Override
    public void updateCommentById(long id, CommentDto commentDto) {

        Optional<Comment> optionalPost = commentRepository.findById(id);

        if (optionalPost.isPresent()) {
            Comment comment = optionalPost.get();
            modelMapper.map(commentDto, comment);

            commentRepository.save(comment);
        } else {
            throw new RuntimeException("comment with id " + id + " not found");
        }
    }


}
