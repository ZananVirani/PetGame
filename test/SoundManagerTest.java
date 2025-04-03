import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import greenfoot.GreenfootSound;

public class SoundManagerTest {

   @Before
   public void setUp() {
      // Stop all sounds before each test
      SoundManager.stopAll();
   }

   @Test
   public void testPlayLobbyMusic() {
      // Initial state
      assertFalse("Lobby music should not be playing initially",
            SoundManager.lobbyMusic.isPlaying());

      // Play lobby music
      SoundManager.playLobbyMusic();
      assertTrue("Lobby music should be playing after playLobbyMusic()",
            SoundManager.lobbyMusic.isPlaying());
   }

   @Test
   public void testPlayLobbyMusicMultipleCalls() {
      // Play lobby music multiple times
      SoundManager.playLobbyMusic();
      boolean firstPlayState = SoundManager.lobbyMusic.isPlaying();

      SoundManager.playLobbyMusic();
      boolean secondPlayState = SoundManager.lobbyMusic.isPlaying();

      assertEquals("Multiple calls to playLobbyMusic should not change playing state",
            firstPlayState, secondPlayState);
   }

   @Test
   public void testPlayBgm() {
      // Initial state
      assertFalse("BGM should not be playing initially",
            SoundManager.bgm.isPlaying());

      // Play BGM
      SoundManager.playBgm();
      assertTrue("BGM should be playing after playBgm()",
            SoundManager.bgm.isPlaying());
   }

   @Test
   public void testStopBgm() {
      // Start BGM
      SoundManager.playBgm();
      assertTrue("BGM should be playing initially",
            SoundManager.bgm.isPlaying());

      // Stop BGM
      SoundManager.stopBgm();
      assertFalse("BGM should not be playing after stopBgm()",
            SoundManager.bgm.isPlaying());
   }

   @Test
   public void testStopAll() {
      // Start all sounds
      SoundManager.playLobbyMusic();
      SoundManager.playBgm();

      // Stop all sounds
      SoundManager.stopAll();

      assertFalse("Lobby music should be stopped after stopAll()",
            SoundManager.lobbyMusic.isPlaying());
      assertFalse("BGM should be stopped after stopBgm()",
            SoundManager.bgm.isPlaying());
   }

   @Test
   public void testSoundInitialization() {
      // Test that all sound objects are properly initialized
      assertNotNull("Lobby music should be initialized", SoundManager.lobbyMusic);
      assertNotNull("BGM should be initialized", SoundManager.bgm);
      assertNotNull("Click sound should be initialized", SoundManager.click);
      assertNotNull("Toy sound should be initialized", SoundManager.toy);
   }
}