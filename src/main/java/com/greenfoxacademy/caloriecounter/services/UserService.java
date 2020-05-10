package com.greenfoxacademy.caloriecounter.services;

import com.greenfoxacademy.caloriecounter.models.User;

import java.util.Optional;

public interface UserService {
  Optional<User> currentUser();
}
