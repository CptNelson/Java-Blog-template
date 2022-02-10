package com.rekrytest.blogapp.controllers;

import com.rekrytest.blogapp.models.Post;
import com.rekrytest.blogapp.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/posts/")
public class PostController {

    @Autowired
    private PostService postService;

    @CrossOrigin
    @GetMapping(value = "/")
    public List<Post> getAllPosts() {
        return postService.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Post> read(@PathVariable("id") String id) {
            Post foundPost = postService.findById(id);
            if (foundPost == null) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(foundPost);
            }
    }

    @CrossOrigin
    @PostMapping("/")
    public ResponseEntity<Post> createPost(@RequestBody Post Post) throws URISyntaxException {
        Post createdPost = postService.saveOrUpdate(Post);
        if (createdPost == null) {
            return ResponseEntity.notFound().build();
        } else {
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(createdPost.getId())
                    .toUri();

            return ResponseEntity.created(uri)
                    .body(createdPost);
        }
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePost(@PathVariable("id") String id) {
        postService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
