package com.greenfoxacademy.caloriecounter.services;

public class FoodStatistics {
  private final double averageCalories;
  private final long numberOfFoods;

  public FoodStatistics(double averageCalories, long numberOfFoods) {
    this.averageCalories = averageCalories;
    this.numberOfFoods = numberOfFoods;
  }

  public double getAverageCalories() {
    return averageCalories;
  }

  public long getNumberOfFoods() {
    return numberOfFoods;
  }
}
