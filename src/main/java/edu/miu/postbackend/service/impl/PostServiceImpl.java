package edu.miu.postbackend.service.impl;


import edu.miu.postbackend.domain.Post;
import edu.miu.postbackend.dto.PostDto;
import edu.miu.postbackend.repo.PostRepository;
import edu.miu.postbackend.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;


    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(post -> modelMapper.map(post, PostDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDto getPostById(long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        Post post = optionalPost.orElseThrow(() -> new RuntimeException("Post with id " + id + " not found"));
        return modelMapper.map(post, PostDto.class);
    }

    @Override
    public void createPost(PostDto postDto) {
        Post post = modelMapper.map(postDto, Post.class);
        postRepository.save(post);
    }

    @Override
    public void deletePostById(long id) {
        postRepository.deleteById(id);
    }

    @Override
    public void updatePostById(long id, PostDto postDto) {
        Optional<Post> optionalPost = postRepository.findById(id);

        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            modelMapper.map(postDto, post);
            postRepository.save(post);
        } else {
            throw new RuntimeException("Post with id " + id + " not found");
        }
    }

    @Override
    public List<Post> findPostByTitle(String tittle) {
        return postRepository.findPostByTitle(tittle);
    }
}
