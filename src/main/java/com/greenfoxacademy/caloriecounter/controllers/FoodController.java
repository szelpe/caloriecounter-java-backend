package com.greenfoxacademy.caloriecounter.controllers;

import com.greenfoxacademy.caloriecounter.models.Food;
import com.greenfoxacademy.caloriecounter.services.FoodService;
import com.greenfoxacademy.caloriecounter.services.FoodServiceImpl;
import com.greenfoxacademy.caloriecounter.services.FoodStatistics;
import com.greenfoxacademy.caloriecounter.services.FoodStatisticsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@RestController
@RequestMapping("/api/foods")
public class FoodController {

  private FoodService foodService;
  private final FoodStatisticsService foodStatisticsService;

  public FoodController(FoodService foodService, FoodStatisticsService foodStatisticsService) {
//    this.foodService = new FoodServiceImpl(); // without DI
    this.foodService = foodService;
    this.foodStatisticsService = foodStatisticsService;
  }

  @GetMapping
  public Collection<Food> list() throws Exception {
    return foodService.findAll();
  }

  @PostMapping
  public ResponseEntity add(@RequestBody @Valid Food food) {
    try {
      foodService.add(food);
    }
    catch(IllegalArgumentException ex) {
      return ResponseEntity.badRequest().build();
    }

    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("{id}")
  public ResponseEntity delete(@PathVariable long id) {
    foodService.delete(id);

//    return new ResponseEntity(HttpStatus.NO_CONTENT);
    return ResponseEntity
            .noContent()
            .build();
  }

  @GetMapping("/statistics")
  public FoodStatistics statistics() {
    Collection<Food> foods = foodService.findAll();
    return this.foodStatisticsService.calculate(new ArrayList<>(foods));
  }

}
