package com.greenfoxacademy.caloriecounter.services;

import com.greenfoxacademy.caloriecounter.models.Food;
import com.greenfoxacademy.caloriecounter.models.WeeklyStatistic;

import java.util.List;

public interface FoodStatisticsService {
  FoodStatistics calculate(List<Food> foods);

  List<WeeklyStatistic> calculateWeekly(List<Food> foods);
}
