package com.codewithyash.store.repositories;

import com.codewithyash.store.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}