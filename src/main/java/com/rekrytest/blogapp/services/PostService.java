package com.rekrytest.blogapp.services;

import com.rekrytest.blogapp.models.Post;

import java.util.List;

public interface PostService {
    List<Post> findAll();
    Post findById(String id);
    Post saveOrUpdate(Post post);
    void deleteById(String id);
}
