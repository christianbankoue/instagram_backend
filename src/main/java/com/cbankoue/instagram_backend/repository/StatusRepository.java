package com.cbankoue.instagram_backend.repository;

import com.cbankoue.instagram_backend.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface StatusRepository extends JpaRepository<Status, Long> {

    @Query("SELECT s FROM Status s WHERE s.user.Id = ?1 ORDER BY id")
    Optional<Object> findAllStatusByUser(Long user_id);
}
