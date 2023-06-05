package edu.miu.postbackend.controller;



import edu.miu.postbackend.domain.Post;


import edu.miu.postbackend.dto.PostDto;
import edu.miu.postbackend.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/posts")  // http://localhost:8080/api/v1/posts
public class PostController {


    @Autowired
    private PostService postService;



    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<PostDto> getAllPosts(){
        return postService.getAllPosts();
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}") // http://localhost:8080/api/v1/posts/1
    public PostDto getPostById(@PathVariable long id){
        return postService.getPostById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping() // http://localhost:8080/api/v1/posts
    public void createPost(@RequestBody PostDto postDto){
        postService.createPost(postDto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}") // http://localhost:8080/api/v1/posts/1
    public void deletePostById(@PathVariable long id){
        postService.deletePostById(id);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}") // http://localhost:8080/api/v1/posts/1
    public void updatePostById(@PathVariable long id, @RequestBody PostDto postDto){
        postService.updatePostById(id, postDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/title/{title}")
    public List<Post> findPostByTitle(@PathVariable String title){
        return postService.findPostByTitle(title) ;
    }
}

