package edu.miu.postbackend.repo;


import edu.miu.postbackend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //Make a query that will return all the users that have more than 1 post

    @Query("SELECT u FROM User u WHERE SIZE(u.posts) > 1")
    List<User> findUserWithMoreThanOnePost();





    @Query("SELECT u FROM User u WHERE SIZE(u.posts) = :postCount")
    List<User> findUserWithNPosts(int postCount);

}
