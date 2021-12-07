package com.cbankoue.instagram_backend.Controller;

import com.cbankoue.instagram_backend.entity.Users;
import com.cbankoue.instagram_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;

    @GetMapping("/{id}")
    private Users getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    private Users createUser(@RequestBody Users userDetails){
        return userService.createUser(userDetails);
    }
}
