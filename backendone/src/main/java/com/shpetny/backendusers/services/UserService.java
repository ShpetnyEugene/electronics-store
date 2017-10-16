package com.shpetny.backendusers.services;

import com.shpetny.backendusers.models.Role;
import com.shpetny.backendusers.models.User;
import com.shpetny.backendusers.persistance.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void createUser(String login, String password) {
        User user = new User(login,password);
        user.setRole(Role.USER);
        repository.save(user);
    }

    public List<User> getAllUsers() {
        return (List<User>) repository.findAll();
    }

    public boolean checkUserByLoginAndPassword(String login, String password) {
        return repository.findByLoginAndPassword(login, password) != null;
    }
}
