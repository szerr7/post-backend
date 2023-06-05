package edu.miu.postbackend.service;



import edu.miu.postbackend.domain.Post;
import edu.miu.postbackend.dto.PostDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service

public interface PostService {

    List<PostDto> getAllPosts();
    PostDto getPostById(long id);
    void createPost(PostDto post);
    void deletePostById(long id);
    void updatePostById(long id, PostDto post);

    List<Post>findPostByTitle(String tittle) ;

}
