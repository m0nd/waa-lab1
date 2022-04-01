package waa.labs.lab1.service;

import waa.labs.lab1.domain.dto.PostDto;
import java.util.List;

public interface PostsService {

    public void savePost(PostDto post);

    public void updatePost(long postId, PostDto post);

    public void deletePostById(long postId);

    public List<PostDto> getAllPosts();

    public List<PostDto> getAllPostsByAuthor(String author);

    public PostDto getPostById(long postId);
}
