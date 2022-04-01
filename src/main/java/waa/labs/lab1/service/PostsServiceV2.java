package waa.labs.lab1.service;

import waa.labs.lab1.domain.dto.PostDtoV2;

import java.util.List;

public interface PostsServiceV2 {
    public void savePostV2(PostDtoV2 post);

    public void updatePostV2(long postId, PostDtoV2 post);

    public void deletePostByIdV2(long postId);

    public List<PostDtoV2> getAllPostsV2();

    public PostDtoV2 getPostByIdV2(long postId);
}
