package com.example.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

public class GameState {
   private static final String PLAYER_SAVE_FILE = "player_save.json";
   private static final String PET_SAVE_DIRECTORY = "pets/";
   private LocalDateTime lastSaved;

   // public GameState() {
   //    this.lastSaved = LocalDateTime.now();
   //    // Create pets directory if it doesn't exist
   //    new File(PET_SAVE_DIRECTORY).mkdirs();
   // }

   public static void savePlayer() {
      try {
         Player.incrementSession();
         ObjectMapper mapper = new ObjectMapper();
         mapper.writeValue(new File(PLAYER_SAVE_FILE), Player.class);
         // this.lastSaved = LocalDateTime.now();
      } catch (IOException e) {
         System.err.println("Error saving player: " + e.getMessage());
      }
   }

   public static void loadPlayer() {
      try {
         ObjectMapper mapper = new ObjectMapper();
         mapper.readValue(new File(PLAYER_SAVE_FILE), Player.class);
      } catch (IOException e) {
         System.err.println("Error loading player: " + e.getMessage());
      }
   }

   public static void savePet(Pet pet) {
      try {
         ObjectMapper mapper = new ObjectMapper();
         String petFileName = PET_SAVE_DIRECTORY + Pet.getName().toLowerCase() + "_save.json";
         mapper.writeValue(new File(petFileName), Pet.class);
         // this.lastSaved = LocalDateTime.now();
         // Add pet name to alivePets array
         for (int i = 0; i < Player.getAlivePets().length; i++) {
            if (Player.getAlivePets()[i] == null) {
               Player.getAlivePets()[i] = Pet.getName();
               break;
            }
         }
      } catch (IOException e) {
         System.err.println("Error saving pet: " + e.getMessage());
      }
   }

   public static Pet loadPet(String petName) {
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