package com.example.secondspringboot;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "users")
public class User {
    @Id
    private Long id;
    @NotNull(message="Name shouldnt be null!")
    private String name;
    @Size(groups={CreateGroup.class, UpdateGroup.class},min=8,max = 50,message="password must be atleast eight characters")
    private String password;

    public User() {}
    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(Long id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
