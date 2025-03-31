package com.example.models;

public class Pet {
   private String name;
   private Health health;
   private Fullness fullness;
   private Happiness happiness;
   private Sleep sleep;
   private Score score;

   private String currentState;

   public Pet(String name, Health health, Fullness fullness, Happiness happiness, Sleep sleep) {
      this.name = name;
      this.health = health;
      this.fullness = fullness;
      this.happiness = happiness;
      this.sleep = sleep;
   }

   public String getName() {
      return name;
   }


   // public void feed(Food food) {
   //    inventory.useFood(food, fullness, score);
   // }

   // public void play(Gift gift) {
   //    inventory.useGift(gift, happiness, score);
   // }



   // public void sleep() {
   //    sleep.increaseSleep(10);
   //    score.increaseScore(5);
   // }

   // public void vet() {
   //    health.increaseHealth(10);
   //    score.increaseScore(5);
   // }

   // public void checkVitals() {
      
   // }
}
