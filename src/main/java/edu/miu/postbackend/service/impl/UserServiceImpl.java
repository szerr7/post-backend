package edu.miu.postbackend.service.impl;

import edu.miu.postbackend.domain.Post;
import edu.miu.postbackend.domain.User;
import edu.miu.postbackend.dto.UserDto;
import edu.miu.postbackend.repo.PostRepository;
import edu.miu.postbackend.repo.UserRepository;
import edu.miu.postbackend.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;


    private ModelMapper modelMapper =  new ModelMapper();

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUsersById(long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public void createUser(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        userRepository.save(user);
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUserById(long id, UserDto userDto) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            modelMapper.map(userDto, user);
            userRepository.save(user);
        } else {
            throw new RuntimeException("User with id " + id + " not found");
        }
    }

    @Override
    public List<Post> getPostsByUserId(long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return user.getPosts();
        } else {
            throw new RuntimeException("User with id " + id + " not found");
        }
    }

    @Override
    public List<User> findUserWithMoreThanOnePost() {
        return userRepository.findUserWithMoreThanOnePost();
    }

    @Override
    public List<User> findUserWithNPosts(int n) {
        List<User> users = userRepository.findUserWithNPosts(n);
        return users;
    }


}
