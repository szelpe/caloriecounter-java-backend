package com.greenfoxacademy.caloriecounter.services;

import com.greenfoxacademy.caloriecounter.models.Food;
import com.greenfoxacademy.caloriecounter.models.WeeklyStatistic;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

  @Override
  public List<WeeklyStatistic> calculateWeekly(List<Food> foods) {
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
