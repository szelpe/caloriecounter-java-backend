package com.greenfoxacademy.caloriecounter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Clock;

@SpringBootApplication
public class CaloriecounterApplication {

  public static void main(String[] args) {
    SpringApplication.run(CaloriecounterApplication.class, args);
  }

  @Bean
  Clock getClock() {
    return Clock.systemUTC();
  }

}
