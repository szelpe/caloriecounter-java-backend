package com.greenfoxacademy.caloriecounter.services;

import com.greenfoxacademy.caloriecounter.models.Food;

import java.util.List;

public interface FoodStatisticsService {
  FoodStatistics calculate(List<Food> foods);
}
