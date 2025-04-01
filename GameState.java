import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Arrays;

public class GameState {
    private static final File PLAYER_SAVE_FILE = new File("player_save.json");
    private static final String PET_SAVE_DIRECTORY = "pets/";
    // private LocalDateTime lastSaved;

    public static void savePlayer() {
        try {
            Player.incrementSession();
            Map<String, Object> playerData = Player.getPlayerData();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(PLAYER_SAVE_FILE, playerData);
        } catch (Exception e) {
            System.err.println("Error saving player: " + e.getMessage());
        }
    }

    public static void loadPlayer() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            LinkedHashMap<String, Object> playerData = mapper.readValue(PLAYER_SAVE_FILE,
                    new TypeReference<LinkedHashMap>() {
                    });
            Player.setPlayerData(playerData);
        } catch (Exception e) {
            System.out.println("here");
            System.err.println("Error loading player: " + e.getMessage());
        }
    }

    public static void savePet() {
        try {
            File dir = new File("pets");
            if (!dir.exists()) {
                boolean wasCreated = dir.mkdirs(); // mkdirs() creates parent directories
            }
            ObjectMapper mapper = new ObjectMapper();
            String petFileName = PET_SAVE_DIRECTORY + PetClass.getName().toLowerCase() + "_save.json";
            Map<String, Object> petData = PetClass.getPetData();
            mapper.writeValue(new File(petFileName), petData);
        } catch (IOException e) {
            System.err.println("Error saving pet: " + e.getMessage());
        }
    }

    public static boolean createNewPet() {
        try {
            if (Player.createPet()) {
                saveAll();
                return true;
            } else
                return false;
        } catch (Exception e) {
            System.err.println("Error saving pet: " + e.getMessage());
            return false;
        }
    }

    public static void loadPet(String petName) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String petFileName = PET_SAVE_DIRECTORY + petName.toLowerCase() + "_save.json";
            Map<String, Object> petData = mapper.readValue(new File(petFileName),
                    new TypeReference<Map<String, Object>>() {
                    });
            PetClass.setPetData(petData);
        } catch (IOException e) {
            System.err.println("Error loading pet: " + e.getMessage());
        }
    }

    public static void saveAll() {
        savePet();
        savePlayer();
    }
}
