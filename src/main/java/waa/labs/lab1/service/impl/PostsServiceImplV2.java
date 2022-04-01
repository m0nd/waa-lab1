package waa.labs.lab1.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import waa.labs.lab1.domain.Post;
import waa.labs.lab1.domain.PostV2;
import waa.labs.lab1.domain.dto.PostDto;
import waa.labs.lab1.domain.dto.PostDtoV2;
import waa.labs.lab1.helper.ListMapper;
import waa.labs.lab1.repo.PostsRepo;
import waa.labs.lab1.repo.PostsRepoV2;
import waa.labs.lab1.service.PostsServiceV2;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostsServiceImplV2 implements PostsServiceV2 {

    private final PostsRepoV2 postsRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ListMapper<PostV2, PostDtoV2> listMapperPostToDto;

    @Override
    public void savePostV2(PostDtoV2 post) {
        postsRepo.save(modelMapper.map(post, PostV2.class));
    }

    @Override
    public void updatePostV2(long postId, PostDtoV2 post) {
        postsRepo.update(postId, modelMapper.map(post, PostV2.class));
    }

    @Override
    public void deletePostByIdV2(long postId) {
        postsRepo.deleteById(postId);
    }

    @Override
    public List<PostDtoV2> getAllPostsV2() {
        return (List<PostDtoV2>) listMapperPostToDto.mapList(postsRepo.getAll(), new PostDtoV2());
    }

    @Override
    public List<PostDtoV2> getAllPostsByAuthorV2(String author) {
        return (List<PostDtoV2>) listMapperPostToDto.mapList(postsRepo.getAllByAuthor(author), new PostDtoV2());
    }

    @Override
    public PostDtoV2 getPostByIdV2(long postId) {
        return (PostDtoV2) modelMapper.map(postsRepo.getById(postId), PostDtoV2.class);
    }
}
