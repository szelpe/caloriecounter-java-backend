package com.greenfoxacademy.caloriecounter.repositories;

import com.greenfoxacademy.caloriecounter.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
