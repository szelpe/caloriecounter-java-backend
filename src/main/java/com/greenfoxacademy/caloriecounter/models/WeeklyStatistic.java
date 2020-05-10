package com.greenfoxacademy.caloriecounter.models;

import java.time.LocalDateTime;

public class WeeklyStatistic {
  private LocalDateTime weekStart;
  private int totalCalories;

  public WeeklyStatistic(LocalDateTime weekStart, int totalCalories) {
    this.weekStart = weekStart;
    this.totalCalories = totalCalories;
  }

  public LocalDateTime getWeekStart() {
    return weekStart;
  }

  public int getTotalCalories() {
    return totalCalories;
  }
}
