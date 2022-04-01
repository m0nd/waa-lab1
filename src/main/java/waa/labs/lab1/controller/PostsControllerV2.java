package waa.labs.lab1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import waa.labs.lab1.domain.dto.PostDtoV2;
import waa.labs.lab1.service.PostsServiceV2;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostsControllerV2 {
    private final PostsServiceV2 postsService;

    PostsControllerV2(PostsServiceV2 postsService) {
        this.postsService = postsService;
    }

    @GetMapping(value = "/", headers = "X-API-VERSION=2")
    public List<PostDtoV2> getAll() {
        return postsService.getAllPostsV2();
    }

    @GetMapping(value = "/{id}", headers = "X-API-VERSION=2")
    public PostDtoV2 getById(@PathVariable("id") int postId) {
        return postsService.getPostByIdV2(postId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/", headers = "X-API-VERSION=2")
    public void save(@RequestBody PostDtoV2 newPost) {
        postsService.savePostV2(newPost);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}", headers = "X-API-VERSION=2")
    public void save(@PathVariable("id") int postId) {
        postsService.deletePostByIdV2(postId);
    }

    @PutMapping(value = "/{id}", headers = "X-API-VERSION=2")
    public void update(@PathVariable("id") int postId, @RequestBody PostDtoV2 post) {
        postsService.updatePostV2(postId, post);
    }
}
