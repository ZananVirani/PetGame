import greenfoot.*;

/**
 * SoundManager handles all sound-related functionality in the game.
 * 
 * This class manages background music, sound effects, and provides methods
 * to control playback of different audio elements. It maintains the state
 * of background music and ensures proper sound management throughout the game.
 * 
 * @author Group 78
 */
public class SoundManager {
    /** Background music that plays in the lobby/menu screens */
    public static GreenfootSound lobbyMusic = new GreenfootSound("lobbyMusic.mp3"); // music that plays everywhere but
                                                                                    // the game screen
    /** Background music that plays in the play with pet screen */
    public static GreenfootSound bgm = new GreenfootSound("bgm.mp3"); // Background music for the playwithpet screen
    /** Sound effect for clicking menu buttons */
    public static GreenfootSound click = new GreenfootSound("click.mp3"); // clicking sounds for all main menu buttons
                                                                          // DO NOT USE FOR ACTIONS
    /** Sound effect for using toys */
    public static GreenfootSound toy = new GreenfootSound("toy.wav"); // give toy button

    private static boolean lobbyMusicPlaying = false;

    /**
     * Starts playing the lobby music in a loop if it's not already playing.
     */
    public static void playLobbyMusic() {
        if (!lobbyMusicPlaying) {
            lobbyMusic.playLoop();
            lobbyMusicPlaying = true;
        }
    }

    /**
     * Starts playing the background music in a loop.
     */
    public static void playBgm() {
        bgm.playLoop();
    }

    /**
     * Plays the click sound effect.
     */
    public static void playClick() {
        Greenfoot.playSound("click.mp3");
    }

    /**
     * Stops the background music.
     */
    public static void stopBgm() {
        bgm.stop();
    }

    /**
     * Stops all currently playing sounds.
     */
    public static void stopAll() {
        lobbyMusic.stop();
    }
}