package waa.labs.lab1.repo;

import org.springframework.stereotype.Repository;
import waa.labs.lab1.domain.Post;
import waa.labs.lab1.domain.PostV2;

import java.util.List;

@Repository
public interface PostsRepoV2 {
    public void save(PostV2 post);

    public void update(long id, PostV2 post);

    public void deleteById(long id);

    public List<PostV2> getAll();

    public List<PostV2> getAllByAuthor(String author);

    public PostV2 getById(long id);
}
