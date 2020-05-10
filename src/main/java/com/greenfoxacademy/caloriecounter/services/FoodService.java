package com.greenfoxacademy.caloriecounter.services;

import com.greenfoxacademy.caloriecounter.models.Food;
import com.greenfoxacademy.caloriecounter.models.WeeklyStatistic;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

public interface FoodService {
  Collection<Food> findAll();

  Food add(Food food);

  void delete(long food);

  List<WeeklyStatistic> getStatistics(LocalDateTime from, LocalDateTime to);
}
