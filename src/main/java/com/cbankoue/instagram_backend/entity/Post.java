package com.cbankoue.instagram_backend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User users;

    private String path;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp;

    private Long likeCount;
}
