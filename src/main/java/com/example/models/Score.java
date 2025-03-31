package com.example.models;

public class Score {
   private int score;

   public Score() {
      this.score = 0;
   }

   public void increaseScore(int amount) {
      this.score += amount;
   }

   public int getScore() {
      return this.score;
   }
}
