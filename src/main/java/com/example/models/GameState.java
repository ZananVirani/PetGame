package com.example.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class GameState {
   private static final String PLAYER_SAVE_FILE = "player_save.json";
   private static final String PET_SAVE_DIRECTORY = "pets/";
   private LocalDateTime lastSaved;

   public GameState() {
      this.lastSaved = LocalDateTime.now();
      // Create pets directory if it doesn't exist
      new File(PET_SAVE_DIRECTORY).mkdirs();
   }

   // public void setTimeRestrictions(LocalTime startTime, LocalTime endTime) {
   //    this.timeRestrictions[0] = startTime;
   //    this.timeRestrictions[1] = endTime;
   // }

   // public boolean isWithinTimeRestrictions() {
   //    LocalTime currentTime = LocalTime.now();
   //    return currentTime.isAfter(timeRestrictions[0]) && currentTime.isBefore(timeRestrictions[1]);
   // }

   // public LocalTime getStartTime() {
   //    return timeRestrictions[0];
   // }

   // public LocalTime getEndTime() {
   //    return timeRestrictions[1];
   // }

   public void savePlayer(Player player) {
      try {
         player.incrementSession();
         ObjectMapper mapper = new ObjectMapper();
         mapper.writeValue(new File(PLAYER_SAVE_FILE), player);
         this.lastSaved = LocalDateTime.now();
      } catch (IOException e) {
         System.err.println("Error saving player: " + e.getMessage());
      }
   }

   public Player loadPlayer() {
      try {
         ObjectMapper mapper = new ObjectMapper();
         return mapper.readValue(new File(PLAYER_SAVE_FILE), Player.class);
      } catch (IOException e) {
         System.err.println("Error loading player: " + e.getMessage());
         return null;
      }
   }

   public void savePet(Player player, Pet pet) {
      try {
         ObjectMapper mapper = new ObjectMapper();
         String petFileName = PET_SAVE_DIRECTORY + pet.getName().toLowerCase() + "_save.json";
         mapper.writeValue(new File(petFileName), pet);
         this.lastSaved = LocalDateTime.now();
         player.getAlivePets().add(pet.getName());
      } catch (IOException e) {
         System.err.println("Error saving pet: " + e.getMessage());
      }
   }

   public Pet loadPet(String petName) {
      try {
         ObjectMapper mapper = new ObjectMapper();
         String petFileName = PET_SAVE_DIRECTORY + petName.toLowerCase() + "_save.json";
         return mapper.readValue(new File(petFileName), Pet.class);
      } catch (IOException e) {
         System.err.println("Error loading pet: " + e.getMessage());
         return null;
      }
   }
}