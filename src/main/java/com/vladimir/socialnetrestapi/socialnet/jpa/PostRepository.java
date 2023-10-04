package com.vladimir.socialnetrestapi.socialnet.jpa;

import com.vladimir.socialnetrestapi.socialnet.user.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
