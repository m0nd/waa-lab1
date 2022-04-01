package waa.labs.lab1.repo.impl;

import org.springframework.stereotype.Repository;
import waa.labs.lab1.domain.Post;
import waa.labs.lab1.domain.dto.PostDto;
import waa.labs.lab1.repo.PostsRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostsRepoImpl implements PostsRepo {
    /*
        Represents our repo. In real app we would just have
        our repo class extend CrudRepository
    */
    private static List<Post> posts;

    static {
        posts = new ArrayList<>();
        Post post1 = new Post(1,"Title 1","Content 1", "Author 1");
        Post post2 = new Post(2,"Title 2","Content 2", "Author 2");
        posts.add(post1);
        posts.add(post2);
    }

    @Override
    public void save(Post post) {
        if (posts.stream().noneMatch(p -> p.getId() == post.getId()))
            posts.add(post);
    }

    @Override
    public void update(long id, Post post) {
        var postToUpdate = posts.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
        var indexToUpdate = posts.indexOf(postToUpdate);
        System.out.println("index to update: " + indexToUpdate);
        posts.set(indexToUpdate, post);
    }

    @Override
    public void deleteById(long id) {
        posts = posts.stream().filter(p -> p.getId() != id).collect(Collectors.toList());
    }

    @Override
    public List<Post> getAll() {
        return posts;
    }

    @Override
    public List<Post> getAllByAuthor(String author) {
        return posts.stream().filter(post -> post.getAuthor().equals(author)).collect(Collectors.toList());
    }

    @Override
    public Post getById(long id) {
        return posts.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }
}
