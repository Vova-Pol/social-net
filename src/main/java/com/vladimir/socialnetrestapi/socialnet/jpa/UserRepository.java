package com.vladimir.socialnetrestapi.socialnet.jpa;

import com.vladimir.socialnetrestapi.socialnet.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
