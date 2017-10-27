package com.shpetny.backendusers.persistance;

import com.shpetny.backendusers.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Shpetny Eugene
 * @version 1.0
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByLogin(String login);
    User findByLoginAndPassword(String login, String password);

    User findById(long id);
}
