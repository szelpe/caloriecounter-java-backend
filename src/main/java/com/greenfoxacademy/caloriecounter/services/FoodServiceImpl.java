package com.greenfoxacademy.caloriecounter.services;

import com.greenfoxacademy.caloriecounter.models.Food;
import com.greenfoxacademy.caloriecounter.models.User;
import com.greenfoxacademy.caloriecounter.models.WeeklyStatistic;
import com.greenfoxacademy.caloriecounter.repositories.FoodRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.Clock;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class FoodServiceImpl implements FoodService {
  private UserService userService;
  private FoodRepository foodRepository;
  private final Clock clock;

  public FoodServiceImpl(UserService userService, FoodRepository foodRepository, Clock clock) {
    this.userService = userService;
    this.foodRepository = foodRepository;
    this.clock = clock;
  }

  @Override
  public Collection<Food> findAll() {
    return foodRepository.findAll()
            .stream()
            .sorted(Comparator.comparing(food -> food.getAddedAt()))
            .collect(Collectors.toList());
  }

  @Override
  public Food add(Food food) {
    if (food == null) {
      throw new IllegalArgumentException("Food must not be null");
    }

    if (StringUtils.isEmpty(food.getName())) {
      throw new IllegalArgumentException("Food name is required");
    }

    if (food.getAmount() < 0) {
      throw new IllegalArgumentException("Food amount must be non-negative");
    }

    Optional<User> optionalUser = userService.currentUser();

    if (!optionalUser.isPresent()) {
      throw new IllegalStateException("User is not logged in");
    }

    food.setAddedAt(LocalDateTime.now(this.clock));
    food.setUser(optionalUser.get());

    return foodRepository.save(food);
  }

  @Override
  public void delete(long foodId) {
    foodRepository.deleteById(foodId);
  }

  @Override
  public List<WeeklyStatistic> getStatistics(LocalDateTime from, LocalDateTime to) {
    Collection<Food> foods = foodRepository.findAllByAddedAtAfterAndAddedAtBefore(from, to);

    return foods.stream()
            .collect(Collectors.groupingBy(f -> getWeekStart(f.getAddedAt())))
            .entrySet()
            .stream()
            .map(e -> new WeeklyStatistic(e.getKey(), getSum(e)))
            .collect(Collectors.toList());
  }

  private int getSum(Map.Entry<LocalDateTime, List<Food>> e) {
    return e.getValue().stream().mapToInt(Food::getAmount).sum();
  }

  private LocalDateTime getWeekStart(LocalDateTime dateTime) {
    return dateTime.with(DayOfWeek.MONDAY).with(LocalTime.MIDNIGHT);
  }
}
