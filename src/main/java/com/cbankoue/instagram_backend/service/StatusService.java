package com.cbankoue.instagram_backend.service;

import com.cbankoue.instagram_backend.entity.Status;
import com.cbankoue.instagram_backend.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    public List<Status> getAllStatusByUser(@PathVariable Long user_id){
        return (List<Status>) statusRepository.findAllStatusByUser(user_id).orElseThrow(() -> new ResourceNotFoundException("no status for user id " + user_id));
    }


    public Status createStatus(@RequestBody Status status){
        return statusRepository.save(status);
    }


    public Status updateStatus(@PathVariable Long status_id, @RequestBody Status statusDetails){
        Status status = statusRepository.findById(status_id).orElseThrow(() ->  new ResourceNotFoundException("No status found with id " + status_id));

        status.setPath(statusDetails.getPath());
        status.setTimeStamp(statusDetails.getTimeStamp());

        return statusRepository.save(status);
    }

    public ResponseEntity<Map<String, Boolean>> deleteStatus(@PathVariable Long status_id){

        Status status = statusRepository.findById(status_id).orElseThrow(() -> new ResourceNotFoundException("No status with id " + status_id));

        statusRepository.delete(status);

        Map<String, Boolean> response = new HashMap<>();
        response.put("delete", true);

        return ResponseEntity.ok(response);
    }
}
