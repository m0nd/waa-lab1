package waa.labs.lab1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import waa.labs.lab1.domain.Post;
import waa.labs.lab1.domain.dto.PostDto;
import waa.labs.lab1.service.PostsService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostsController {

    private final PostsService postsService;

    @Autowired
    PostsController(PostsService postsService) {
        this.postsService = postsService;
    }

    @GetMapping("/")
    public List<PostDto> getAll(@RequestParam(value = "filter", required = false) String author) {
        return author == null ? postsService.getAllPosts() : postsService.getAllPostsByAuthor(author);
    }

    @GetMapping("/{id}")
    public PostDto getById(@PathVariable("id") int postId) {
        return postsService.getPostById(postId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/")
    public void save(@RequestBody PostDto newPost) {
        postsService.savePost(newPost);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void save(@PathVariable("id") int postId) {
        postsService.deletePostById(postId);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int postId, @RequestBody PostDto post) {
        postsService.updatePost(postId, post);
    }
}
