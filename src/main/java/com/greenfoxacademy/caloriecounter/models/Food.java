package com.greenfoxacademy.caloriecounter.models;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Food {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private long id;

  @NotNull
  @Length(min = 1)
  private String name;

  @Min(0)
  private Integer amount;

  private LocalDateTime addedAt;

  @ManyToOne
  private User user;

  public Food(String name, Integer amount) {
    this.name = name;
    this.amount = amount;
  }

  public Food(String name, Integer amount, LocalDateTime addedAt) {
    this.name = name;
    this.amount = amount;
    this.addedAt = addedAt;
  }

  public Food() {
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public LocalDateTime getAddedAt() {
    return addedAt;
  }

  public void setAddedAt(LocalDateTime addedAt) {
    this.addedAt = addedAt;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
