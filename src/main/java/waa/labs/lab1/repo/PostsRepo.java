package waa.labs.lab1.repo;

import org.springframework.stereotype.Repository;
import waa.labs.lab1.domain.Post;
import waa.labs.lab1.domain.dto.PostDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface PostsRepo {
    public void save(Post post);

    public void update(long id, Post post);

    public void deleteById(long id);

    public List<Post> getAll();

    public List<Post> getAllByAuthor(String author);

    public Post getById(long id);
 }
