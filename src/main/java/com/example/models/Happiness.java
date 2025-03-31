package com.example.models;

public class Happiness extends Vital {
   private int value;

   public Happiness(int value) {
      super(value);
   }

   public void increaseHappiness(int value) {
      super.increaseValue(value);
   }

   public void decreaseHappiness(int value) {
      super.decreaseValue(value);
   }  

   // public void Angry() {
   //    if(super.getValue() <= 0){
   //       //How to deny commands
   //    }
   // }
}
