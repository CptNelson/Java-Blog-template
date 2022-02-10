package com.rekrytest.blogapp.services;

import com.rekrytest.blogapp.models.Post;
import com.rekrytest.blogapp.repositories.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }


    @Override
    public Post findById(String id) {
            Post post = postRepository.findById(id).orElse(null);
            return post;
    }

    @Override
    public Post saveOrUpdate(Post post) {
        return postRepository.save(post);
    }
    @Override
    public void deleteById(String id) {
        postRepository.deleteById(id);
    }

}
