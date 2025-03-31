 

import java.util.List;
import java.util.ArrayList;

public class Inventory {
   private List<Food> foodItems;
   private List<Gift> giftItems;

   public Inventory() {
      this.foodItems = new ArrayList<>();
      this.giftItems = new ArrayList<>();
   }

   public void addFood(Food food) {
      foodItems.add(food);
   }

   public void addGift(Gift gift) {
      giftItems.add(gift);
   }

   public boolean hasFood(Food food) {
      return this.foodItems.contains(food);
   }

   public boolean hasGift(Gift gift) {
      return this.giftItems.contains(gift);
   }

   public List<Food> getFoodItems() {
      return foodItems;
   }

   public List<Gift> getGiftItems() {
      return giftItems;
   }

   public void useFood(Food food) {
      if (this.hasFood(food)) {
         PetClass.increaseVital(PetClass.getFullness(), food.getValue());
         PetClass.increaseScore(10);
         foodItems.remove(food);
      } else {
         // Error message or something
      }
   }

   public void useGift(Gift gift) {
      if (this.hasGift(gift)) {
         PetClass.increaseVital(PetClass.getHappiness(), gift.getValue());
         PetClass.increaseScore(10);
         giftItems.remove(gift);
      } else {
         // Error message or something
      }
   }

}
