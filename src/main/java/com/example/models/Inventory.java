package com.example.models;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Inventory {
   private List<Food> foodItems;
   private List<Gift> giftItems;
   private List<Food> randomFoods;
   private List<Gift> randomGifts;
   private Random random;

   public Inventory() {
      this.foodItems = new ArrayList<>();
      this.giftItems = new ArrayList<>();
      this.random = new Random();

      this.randomFoods = new ArrayList<>();
      randomFoods.add(new Food("Apple", 10));
      randomFoods.add(new Food("Banana", 10));
      randomFoods.add(new Food("Cherry", 10));
      randomFoods.add(new Food("Date", 10));
      randomFoods.add(new Food("Elderberry", 10));
      randomFoods.add(new Food("Fig", 10));

      this.randomGifts = new ArrayList<>();
      randomGifts.add(new Gift("Toy", 10));
      randomGifts.add(new Gift("Ball", 10));
      randomGifts.add(new Gift("Bone", 10));
      randomGifts.add(new Gift("Chew Toy", 10));
      randomGifts.add(new Gift("Squeaky Toy", 10));
   }

   public void addFood() {
      int randomIndex = random.nextInt(randomFoods.size());
      foodItems.add(randomFoods.get(randomIndex));
   }

   public void addGift() {
      int randomIndex = random.nextInt(randomGifts.size());
      giftItems.add(randomGifts.get(randomIndex));
   }

   // ... existing code ...
}