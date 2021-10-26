package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class PostService {
    private final PostRepository posts;

    public PostService(PostRepository posts) {
        this.posts = posts;
    }

    public void save(Post post) {
        Calendar calendar;
        if (post.getId() == 0) {
            calendar = Calendar.getInstance();
        } else {
            calendar = posts.findById(post.getId()).get().getCreated();
        }
        post.setCreated(calendar);
        posts.save(post);
    }

    public Post findById(int id) {
        return posts.findById(id).get();
    }

    public List<Post> findAll() {
        List<Post> rsl = new ArrayList<>();
        posts.findAll().forEach(rsl::add);
        return rsl;
    }
}
