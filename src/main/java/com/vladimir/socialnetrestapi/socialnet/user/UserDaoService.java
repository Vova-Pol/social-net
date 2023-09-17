package com.vladimir.socialnetrestapi.socialnet.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Jered", LocalDate.now().minusYears(28)));
        users.add(new User(2, "Billy", LocalDate.now().minusYears(23)));
        users.add(new User(3, "Frank", LocalDate.now().minusYears(35)));
        users.add(new User(4, "Amy", LocalDate.now().minusYears(26)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId() == id;
        return users.stream().filter(predicate).findFirst().get();
    }
}
