package com.cbankoue.instagram_backend.Controller;

import com.cbankoue.instagram_backend.entity.User;
import com.cbankoue.instagram_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    private User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    private User createUser(@RequestBody User userDetails){
        return userService.createUser(userDetails);
    }
}
