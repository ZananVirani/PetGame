package com.example.models;

import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Player {
   private Pet pet;
   private int numberOfSessions;
   private Duration totalTimeSpent;
   private boolean parentPass;
   private List<String> alivePets;
   private List<String> deceasedPets;
   private LocalTime[] timeRestrictions; // Array to store start and end times

   public Player(String name, int age, Pet pet) {
      this.pet = pet;
      this.numberOfSessions = 0;
      this.totalTimeSpent = Duration.ZERO;
      this.parentPass = false;
      this.alivePets = new ArrayList<>();
      this.deceasedPets = new ArrayList<>();
      this.timeRestrictions = new LocalTime[2]; // Initialize array for start and end times
   }

   public void setTimeRestrictions(LocalTime startTime, LocalTime endTime) {
      if (parentPass) {
         this.timeRestrictions[0] = startTime;
         this.timeRestrictions[1] = endTime;
         System.out.println("Time restrictions set from " + startTime + " to " + endTime);
      } else {
         System.out.println("Parent pass required to set time restrictions");
      }
   }

   public boolean isWithinTimeRestrictions() {
      if (timeRestrictions[0] == null || timeRestrictions[1] == null) {
         return true; // If no restrictions set, allow play at any time
      }
      LocalTime currentTime = LocalTime.now();
      return currentTime.isAfter(timeRestrictions[0]) && currentTime.isBefore(timeRestrictions[1]);
   }

   public LocalTime getStartTime() {
      return timeRestrictions[0];
   }

   public LocalTime getEndTime() {
      return timeRestrictions[1];
   }

   public void incrementSession() {
      numberOfSessions++;
   }

   public void newGame(Player newPlayer) {
      GameState newGame = new GameState(newPlayer);
   }

   // TODO: Add stats method
   public void stats() {
      System.out.println("Player Name: " + name);
      System.out.println("Age: " + age);
      System.out.println("Number of Sessions: " + numberOfSessions);
      System.out.println("Total Time Spent: " + totalTimeSpent);
      System.out.println("Parent Pass: " + parentPass);
      if (timeRestrictions[0] != null && timeRestrictions[1] != null) {
         System.out.println("Play Time: " + timeRestrictions[0] + " to " + timeRestrictions[1]);
      }
   }

}