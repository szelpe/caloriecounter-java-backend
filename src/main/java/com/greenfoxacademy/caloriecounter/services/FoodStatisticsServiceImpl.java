package com.greenfoxacademy.caloriecounter.services;

import com.greenfoxacademy.caloriecounter.models.Food;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodStatisticsServiceImpl implements FoodStatisticsService {

  @Override
  public FoodStatistics calculate(List<Food> foods) {
    long numberOfFoods = foods.size();
    double averageCalories = foods.stream()
            .mapToInt(Food::getAmount)
            .average()
            .orElseThrow(IllegalStateException::new);

    return new FoodStatistics(averageCalories, numberOfFoods);
  }
}
