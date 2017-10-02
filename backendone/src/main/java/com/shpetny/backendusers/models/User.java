package com.shpetny.backendusers.models;


import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    // TODO Возможно довить еще полей
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;
    private String login;
    private String password;
    @ElementCollection(targetClass = Long.class)
    private List<Long> productsId;

    private Role role;

    // История покупок

    public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public Role getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }
}
