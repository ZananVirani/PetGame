package com.example.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GameState {
   private Player player;
   private LocalDateTime lastSaved;
   private List<Pet> deceasedPets;
   private static final String SAVE_FILE = "game_save.json";

   public GameState(Player player) {
      this.deceasedPets = new ArrayList<>();
   }

   public void saveGame() {
      try {
         ObjectMapper mapper = new ObjectMapper();
         mapper.writeValue(new File(SAVE_FILE), this);
         this.lastSaved = LocalDateTime.now();
      } catch (IOException e) {
         System.err.println("Error saving game: " + e.getMessage());
      }
   }

   public static GameState loadGame() {
      try {
         ObjectMapper mapper = new ObjectMapper();
         return mapper.readValue(new File(SAVE_FILE), GameState.class);
      } catch (IOException e) {
         System.err.println("Error loading game: " + e.getMessage());
         return null;
      }
   }

   public void storeDeceasedPet(Pet pet) {
      deceasedPets.add(pet);
      saveGame(); // Save immediately when a pet dies
   }

   public Pet revivePet(String petName) {
      for (Pet pet : deceasedPets) {
         if (pet.getName().equals(petName)) {
            deceasedPets.remove(pet);
            pet.getHealth().increaseValue(100); // Restore health
            player = new Player(player.getName(), player.getAge(), pet.getName(), pet.getType());
            player.getPet().levelUp(); // Optional: give a level boost on revival
            saveGame();
            return pet;
         }
      }
      return null;
   }

   public List<Pet> getDeceasedPets() {
      return new ArrayList<>(deceasedPets); // Return a copy to prevent external modification
   }

   // Getters and setters
   public Player getPlayer() {
      return player;
   }

   public LocalDateTime getLastSaved() {
      return lastSaved;
   }
}