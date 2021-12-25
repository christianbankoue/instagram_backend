package com.cbankoue.instagram_backend.service;

import com.cbankoue.instagram_backend.entity.User;
import com.cbankoue.instagram_backend.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public User createUser(User userDetails) {

        return userRepo.save(userDetails);
    }

    public User getUserById(Long id) {
        return userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with id " + id + " not found"));
    }

}
