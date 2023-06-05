package edu.miu.postbackend.repo;



import edu.miu.postbackend.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {


    //Make a query that will find all the posts that match a given title

    @Query("SELECT p FROM Post p WHERE p.title = :title")
    List<Post> findPostByTitle(@Param("title") String title);


}



