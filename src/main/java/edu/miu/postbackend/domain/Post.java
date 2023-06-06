package edu.miu.postbackend.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    private String title;
    private String content;
    private String author;

//    @OneToMany(mappedBy = "post" , cascade = CascadeType.PERSIST , fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true , fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonManagedReference
    private List<Comment> comments;


    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "userAuth_id")
    private UserAuth userAuth;



}
