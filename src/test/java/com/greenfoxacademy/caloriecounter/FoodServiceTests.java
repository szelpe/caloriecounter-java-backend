package com.greenfoxacademy.caloriecounter;

import com.greenfoxacademy.caloriecounter.models.Food;
import com.greenfoxacademy.caloriecounter.models.User;
import com.greenfoxacademy.caloriecounter.repositories.FoodRepository;
import com.greenfoxacademy.caloriecounter.services.FoodServiceImpl;
import com.greenfoxacademy.caloriecounter.services.FoodStatisticsService;
import com.greenfoxacademy.caloriecounter.services.UserService;
import com.greenfoxacademy.caloriecounter.services.UserServiceImpl;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class FoodServiceTests {
  @Test
  public void findAllShouldReturnCorrectFoods() {
    // AAA pattern
    // Arrange
    UserService userService = new MockUserService();
    FoodRepository foodRepository = Mockito.mock(FoodRepository.class);
    var foodStatisticsService = Mockito.mock(FoodStatisticsService.class);

    FoodServiceImpl foodService = new FoodServiceImpl(userService, foodRepository, foodStatisticsService);
    List<Food> fakeFoods = Arrays.asList(
            new Food("Test food", 1, LocalDateTime.now()),
            new Food("Test food 2", 2, LocalDateTime.now())
    );

    Mockito.when(foodRepository.findAll()).thenReturn(fakeFoods);

    // Act
    Collection<Food> foods = foodService.findAll();

    // Assert
    // assertEquals(2, foods.size());
    assertThat(foods, hasSize(2));
  }
}

class MockUserService implements UserService {

  @Override
  public Optional<User> currentUser() {
    return Optional.of(new User("Mr Fake"));
  }
}

//class MockFoodRepository implements FoodRepository {
//
//  @Override
//  public <S extends Food> S save(S entity) {
//    return null;
//  }
//
//  @Override
//  public <S extends Food> Iterable<S> saveAll(Iterable<S> entities) {
//    return null;
//  }
//
//  @Override
//  public Optional<Food> findById(Long aLong) {
//    return Optional.empty();
//  }
//
//  @Override
//  public boolean existsById(Long aLong) {
//    return false;
//  }
//
//  @Override
//  public Collection<Food> findAll() {
//    return fakeFoods;
//  }
//
//  @Override
//  public Iterable<Food> findAllById(Iterable<Long> longs) {
//    return null;
//  }
//
//  @Override
//  public long count() {
//    return 0;
//  }
//
//  @Override
//  public void deleteById(Long aLong) {
//
//  }
//
//  @Override
//  public void delete(Food entity) {
//
//  }
//
//  @Override
//  public void deleteAll(Iterable<? extends Food> entities) {
//
//  }
//
//  @Override
//  public void deleteAll() {
//
//  }
//
//  @Override
//  public Collection<Food> findAllByAddedAtAfterAndAddedAtBefore(LocalDateTime from, LocalDateTime to) {
//    return null;
//  }
//}

