package edu.miu.postbackend.controller;



import edu.miu.postbackend.dto.CommentDto;
import edu.miu.postbackend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping() // http://localhost:8085/api/v1/comments
    public List<CommentDto> getAllComments(){
        return commentService.getAllComments();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}") // http://localhost:8085/api/v1/comments/1
    public CommentDto getCommentById(@PathVariable long id){
        return commentService.getCommentById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping() // http://localhost:8085/api/v1/comments
    public void createComment(@RequestBody CommentDto commentDto){
        commentService.createComment(commentDto);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}") // http://localhost:8085/api/v1/comments/1
    public void deleteCommentById(@PathVariable long id){
        commentService.deleteCommentById(id);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}") // http://localhost:8085/api/v1/comments/1
    public void updateCommentById(@PathVariable long id, @RequestBody CommentDto commentDto){
        commentService.updateCommentById(id, commentDto);
    }

}
