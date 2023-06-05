package edu.miu.postbackend.service;




import edu.miu.postbackend.domain.Post;
import edu.miu.postbackend.domain.User;
import edu.miu.postbackend.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();

    UserDto getUsersById(long id);

    void createUser(UserDto post);

    void deleteUserById(long id);

    void updateUserById(long id, UserDto userDto);

    List<Post> getPostsByUserId(long id);

    List<User> findUserWithMoreThanOnePost();

    List<User>findUserWithNPosts(int n);

}
