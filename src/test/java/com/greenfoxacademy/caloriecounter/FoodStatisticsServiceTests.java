package com.greenfoxacademy.caloriecounter;

import com.greenfoxacademy.caloriecounter.models.Food;
import com.greenfoxacademy.caloriecounter.services.FoodStatistics;
import com.greenfoxacademy.caloriecounter.services.FoodStatisticsServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FoodStatisticsServiceTests {

  @Test
  public void calculateShouldReturnCorrectNumberOfFoods() {
    // AAA pattern for unit tests

    // Arrange
    FoodStatisticsServiceImpl foodStatisticsService = new FoodStatisticsServiceImpl();
    List<Food> foods = Arrays.asList(
            new Food("Test food", 1),
            new Food("Test food 2", 2)
    );

    // Act - I call the method under test
    FoodStatistics stats = foodStatisticsService.calculate(foods);

    // Assert
    Assert.assertEquals(2, stats.getNumberOfFoods());
  }
}
