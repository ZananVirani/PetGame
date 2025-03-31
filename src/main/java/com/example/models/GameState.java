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

   public void savePlayer() {
      try {
         Player.incrementSession();
         ObjectMapper mapper = new ObjectMapper();
         mapper.writeValue(new File(PLAYER_SAVE_FILE), Player.class);
         this.lastSaved = LocalDateTime.now();
      } catch (IOException e) {
         System.err.println("Error saving player: " + e.getMessage());
      }
   }

   public void loadPlayer() {
      try {
         File saveFile = new File(PLAYER_SAVE_FILE);
         if (!saveFile.exists()) {
            System.out.println("No save file found. Starting new game.");
            Player.Setup(); // Initialize with default values
            return;
         }

         ObjectMapper mapper = new ObjectMapper();
         Player playerData = mapper.readValue(saveFile, Player.class);

         // Since Player is static, we need to manually copy the values
         Player.setPet(playerData.getPet());
         Player.setNumberOfSessions(playerData.getNumberOfSessions());
         Player.setTotalTimeSpent(playerData.getTotalTimeSpent());
         Player.setParentPass(playerData.getParentPass());
         Player.setAlivePets(playerData.getAlivePets());
         Player.setDeceasedPets(playerData.getDeceasedPets());
         Player.setTimeRestrictions(playerData.getTimeRestrictions());

         System.out.println("Player data loaded successfully.");
      } catch (IOException e) {
         System.err.println("Error loading player: " + e.getMessage());
         Player.Setup(); // Initialize with default values on error
      }
   }

   public void savePet(Pet pet) {
      try {
         ObjectMapper mapper = new ObjectMapper();
         String petFileName = PET_SAVE_DIRECTORY + pet.getName().toLowerCase() + "_save.json";
         mapper.writeValue(new File(petFileName), pet);
         this.lastSaved = LocalDateTime.now();
         // Add pet name to alivePets array
         String[] alivePets = Player.getAlivePets();
         for (int i = 0; i < alivePets.length; i++) {
            if (alivePets[i] == null) {
               alivePets[i] = pet.getName();
               break;
            }
         }
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