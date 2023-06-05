package edu.miu.postbackend.controller;



import edu.miu.postbackend.domain.Post;
import edu.miu.postbackend.domain.User;
import edu.miu.postbackend.dto.UserDto;
import edu.miu.postbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {


    @Autowired
    private UserService userService;


    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable long id){
        return userService.getUsersById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public void createUser(@RequestBody UserDto userDto){
        userService.createUser(userDto);
    }

@ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable long id){
        userService.deleteUserById(id);

    }

@ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void updateUserById(@PathVariable long id, @RequestBody UserDto userDto){
        userService.updateUserById(id, userDto);
    }


    //d.GET	localhost:8080/users/1/posts
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}/posts")
    public List<Post> getPostsByUserId(@PathVariable long id){
        return userService.getPostsByUserId(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("users-with-more-than-one-post")
    public List<User> findUserWithMoreThanOnePost(){
        return userService.findUserWithMoreThanOnePost();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("users-with-n-posts/{n}") //d.GET	localhost:8080/users/users-with-n-posts/2
    public List<User> findUserWithNPosts(@PathVariable int n){
        return userService.findUserWithNPosts(n);

    }
}
