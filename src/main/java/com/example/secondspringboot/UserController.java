package com.example.secondspringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    UserRepository userRepository;
    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
        userRepository.save(new User(3L,"James"));
    }


    private List<User> userList = new ArrayList<>(
            List.of(new User(1L, "Tom"), new User(2L, "Jerry"))

    );

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public String addUser(@RequestBody User user) { //binds Json with User object
        userList.add(user);
        userRepository.save(user);
        return "User added: " + user.getName();
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "User deleted with ID: " + id;
        } else {
            return "User with ID " + id + " not found.";
        }
    }


}
