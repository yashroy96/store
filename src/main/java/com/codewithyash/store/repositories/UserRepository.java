package com.codewithyash.store.repositories;

import com.codewithyash.store.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}