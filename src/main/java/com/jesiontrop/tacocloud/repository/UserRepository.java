package com.jesiontrop.tacocloud.repository;

import com.jesiontrop.tacocloud.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
