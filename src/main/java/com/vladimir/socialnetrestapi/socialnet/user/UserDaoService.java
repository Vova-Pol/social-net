package com.vladimir.socialnetrestapi.socialnet.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int usersIdCount = 0;

    static {
        users.add(new User(++usersIdCount, "Jered", LocalDate.now().minusYears(28), "12345"));
        users.add(new User(++usersIdCount, "Billy", LocalDate.now().minusYears(23), "hello"));
        users.add(new User(++usersIdCount, "Frank", LocalDate.now().minusYears(35), "qwerty"));
        users.add(new User(++usersIdCount, "Amy", LocalDate.now().minusYears(26), "my-password"));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId() == id;
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public void deleteById(int id) {
        Predicate<? super User> predicate = user -> user.getId() == id;
        users.removeIf(predicate);
    }

    public User save(User user) {
        user.setId(++usersIdCount);
        users.add(user);
        return user;
    }
}
