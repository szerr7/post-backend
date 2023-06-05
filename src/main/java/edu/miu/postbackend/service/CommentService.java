package edu.miu.postbackend.service;




import edu.miu.postbackend.dto.CommentDto;

import java.util.List;

public interface CommentService {

   List<CommentDto> getAllComments();
    CommentDto getCommentById(long id);
    void createComment(CommentDto commentDto);
    void deleteCommentById(long id);
    void updateCommentById(long id, CommentDto commentDto);
}
