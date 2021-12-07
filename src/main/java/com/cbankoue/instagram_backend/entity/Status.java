package com.cbankoue.instagram_backend.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Status {
    @Id
    @GeneratedValue
    private Long ind;

    private String path;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;
}
