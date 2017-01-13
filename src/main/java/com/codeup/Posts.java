package com.codeup;

import java.util.List;

public interface Posts {
    List<Post> all();

    void insert(Post post);
    Post singlePost(int postId);
    void updatePost(Post post);
    void deletePost(int id);
}
