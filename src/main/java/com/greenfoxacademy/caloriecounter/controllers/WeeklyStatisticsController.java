package com.greenfoxacademy.caloriecounter.controllers;

import com.greenfoxacademy.caloriecounter.models.WeeklyStatistic;
import com.greenfoxacademy.caloriecounter.services.FoodService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/weekly-statistics")
public class WeeklyStatisticsController {

  private FoodService foodService;

  public WeeklyStatisticsController(FoodService foodService) {
    this.foodService = foodService;
  }

  @GetMapping
  public WeeklyStatisticsResponse get(@RequestParam LocalDateTime from, @RequestParam LocalDateTime to) {
    return new WeeklyStatisticsResponse(foodService.getStatistics(from, to));
  }

  private static class WeeklyStatisticsResponse {
    public List<WeeklyStatistic> weeks;

    public WeeklyStatisticsResponse() {
      weeks = new ArrayList<>();
    }

    public WeeklyStatisticsResponse(List<WeeklyStatistic> weeks) {
      this.weeks = weeks;
    }
  }
}
