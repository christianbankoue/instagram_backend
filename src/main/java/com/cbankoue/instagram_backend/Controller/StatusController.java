package com.cbankoue.instagram_backend.Controller;

import com.cbankoue.instagram_backend.entity.Status;
import com.cbankoue.instagram_backend.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping("/{user_id}")
    private List<Status> getAllStatusByUser(@PathVariable Long user_id){
        return statusService.getAllStatusByUser(user_id);
    }

    @PostMapping
    private Status createStatus(@RequestBody Status status){
        return statusService.createStatus(status);
    }

    @PutMapping("/{id}")
    private Status updateStatus(@PathVariable Long status_id, @RequestBody Status statusDetails){
        return statusService.updateStatus(status_id, statusDetails);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Map<String, Boolean>> deleteStatus(@PathVariable Long status_id){
        return statusService.deleteStatus(status_id);

    }

}
