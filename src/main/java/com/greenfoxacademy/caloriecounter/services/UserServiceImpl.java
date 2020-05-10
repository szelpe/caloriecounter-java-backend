package com.greenfoxacademy.caloriecounter.services;

import com.greenfoxacademy.caloriecounter.models.User;
import com.greenfoxacademy.caloriecounter.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;

  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public Optional<User> currentUser() {
    return Optional.of(getOrCreateUser());
  }

  private User getOrCreateUser() {
    Optional<User> optionalUser = userRepository.findById(1L);

    if (optionalUser.isPresent()) {
      return optionalUser.get();
    }

    return userRepository.save(new User("petike"));
  }
}
