package waa.labs.lab1.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import waa.labs.lab1.domain.Post;
import waa.labs.lab1.domain.dto.PostDto;
import waa.labs.lab1.helper.ListMapper;
import waa.labs.lab1.repo.PostsRepo;
import waa.labs.lab1.service.PostsService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostsServiceImpl implements PostsService {

    private final PostsRepo postsRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ListMapper<Post, PostDto> listMapperPostToDto;

    @Override
    public void savePost(PostDto post) {
        postsRepo.save(modelMapper.map(post, Post.class));
    }

    @Override
    public void updatePost(long postId, PostDto post) {
        postsRepo.update(postId, modelMapper.map(post, Post.class));
    }

    @Override
    public void deletePostById(long postId) {
        postsRepo.deleteById(postId);
    }

    @Override
    public List<PostDto> getAllPosts() {
        return (List<PostDto>) listMapperPostToDto.mapList(postsRepo.getAll(), new PostDto()) ;
    }

    @Override
    public List<PostDto> getAllPostsByAuthor(String author) {
        return (List<PostDto>) listMapperPostToDto.mapList(postsRepo.getAllByAuthor(author), new PostDto()) ;
    }

    @Override
    public PostDto getPostById(long postId) {
        return (PostDto) modelMapper.map(postsRepo.getById(postId), PostDto.class);
    }
}
