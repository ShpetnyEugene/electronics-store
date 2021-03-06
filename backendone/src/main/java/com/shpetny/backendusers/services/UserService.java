package com.shpetny.backendusers.services;

import com.shpetny.backendusers.models.Role;
import com.shpetny.backendusers.models.User;
import com.shpetny.backendusers.persistance.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void createUser(String login, String password) {
        User user = new User(login, password);
        user.setRole(Role.USER);
        repository.save(user);
    }

    public User getByLogin(String login) {
        return repository.findByLogin(login);
    }

    public boolean checkUserByLoginAndPassword(String login, String password) {
        return repository.findByLoginAndPassword(login, password) != null;
    }

    public User getUserById(long id) {
        return repository.findById(id);
    }

    public boolean checkUserByLoginPasswordRole(String login, String password) {
        User user = repository.findByLoginAndPassword(login, password);
        return user != null && user.getRole() == Role.ADMIN;
    }
}
