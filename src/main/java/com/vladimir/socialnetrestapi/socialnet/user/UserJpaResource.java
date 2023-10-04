package com.vladimir.socialnetrestapi.socialnet.user;

import com.vladimir.socialnetrestapi.socialnet.jpa.PostRepository;
import com.vladimir.socialnetrestapi.socialnet.jpa.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserJpaResource {
    private UserDaoService service;
    private UserRepository userRepository;
    private PostRepository postRepository;

    public UserJpaResource(UserDaoService service, UserRepository userRepository, PostRepository postRepository) {
        this.service = service;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    @GetMapping("/jpa/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/jpa/users/{id}")
    public Optional<User> getUserById(@PathVariable int id) {

        Optional<User> foundUser = userRepository.findById(id);

        if (foundUser.isEmpty())
            throw new UserNotFoundException("id:" + id);

        return foundUser;
    }

    @PostMapping("/jpa/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void deleteUserById(@PathVariable int id) {
        userRepository.deleteById(id);
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> getUserPosts(@PathVariable int id) {
        Optional<User> foundUser = userRepository.findById(id);

        if (foundUser.isEmpty())
            throw new UserNotFoundException("id:" + id);

        return foundUser.get().getPosts();
    }

    @PostMapping("/jpa/users/{id}/posts")
    public void createUserPost(@PathVariable int id, @Valid @RequestBody Post post) {
        Optional<User> foundUser = userRepository.findById(id);

        if (foundUser.isEmpty())
            throw new UserNotFoundException("id:" + id);

        post.setUser(foundUser.get());

        postRepository.save(post);

    }
}
