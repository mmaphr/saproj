package com.example.sa.g22.demo.Entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Data
@Entity
@Table(name="user")
public class User {
    @Id
    @SequenceGenerator(name="user_seq",sequenceName="user_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_seq")
    @Column(name="USER_ID",unique = true, nullable = false)
    private @NonNull Long userId;
    private @NonNull String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return  username;
    }
}
