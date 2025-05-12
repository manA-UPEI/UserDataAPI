package com.example.secondspringboot;

import jakarta.validation.Valid;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
    public ResponseEntity<String> addUser( @RequestBody @Valid User user) { //binds Json with User object
        userList.add(user);
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User added: " + user.getName());
    }

    @DeleteMapping("/{i}")
    public ResponseEntity<String> deleteUser(@PathVariable("i") Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return ResponseEntity.ok( "User deleted with ID: " + id);
        } else {
            //return ResponseEntity.notFound().build(); //without Body!
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found"); //build can be skipped
        }
    }


}
