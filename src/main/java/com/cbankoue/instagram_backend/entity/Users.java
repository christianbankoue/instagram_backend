package com.cbankoue.instagram_backend.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name= "user_table")
public class Users {

    @Id
    @GeneratedValue
    private Long Id;

    @NotNull
    @Column(unique = true)
    private String username;

    private String name;

    private String profileImage;
}
