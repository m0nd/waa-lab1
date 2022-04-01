package waa.labs.lab1.repo.impl;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import waa.labs.lab1.domain.Post;
import waa.labs.lab1.domain.PostV2;
import waa.labs.lab1.repo.PostsRepoV2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostsRepoImplV2 implements PostsRepoV2 {
    /*
        Represents our repo. In real app we would just have
        our repo class extend CrudRepository
    */
    private static List<PostV2> posts;

    static {
        posts = new ArrayList<>();
        PostV2 post1 = new PostV2(1,"Title 1 V2","Content 1 V2", "Author 1 V2");
        PostV2 post2 = new PostV2(2,"Title 2 V2","Content 2 V2", "Author 2 V2");
        posts.add(post1);
        posts.add(post2);
    }

    @Override
    public void save(PostV2 post) {
        if (posts.stream().noneMatch(p -> p.getId() == post.getId()))
            posts.add(post);
    }

    @Override
    public void update(long id, PostV2 post) {
        var postToUpdate = posts.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
        var indexToUpdate = posts.indexOf(postToUpdate);
        posts.set(indexToUpdate, post);
    }

    @Override
    public void deleteById(long id) {
        posts = posts.stream().filter(p -> p.getId() != id).collect(Collectors.toList());
    }

    @Override
    public List<PostV2> getAll() {
        return posts;
    }

    @Override
    public PostV2 getById(long id) {
        return posts.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }
}
