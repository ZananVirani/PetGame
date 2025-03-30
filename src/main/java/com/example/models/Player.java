package com.example.models;

public class Player {
   private String name;
   private int age;
   private Pet pet;
   private int numberOfSessions;
   private Duration totalTimeSpent;
   private boolean parentPass;

   public Player(String name, int age, Pet pet) {
      this.pet = pet;
      this.numberOfSessions = 0;
      this.totalTimeSpent = Duration.ZERO;
   }

   public void newGame(Player newPlayer) {
      
      GameState newGame = new GameState(newPlayer);
   }

   //TODO: Add stats method

   //Implement parent methods here - parent pass must be true to execute

}