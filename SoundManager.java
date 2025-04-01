import greenfoot.*;

public class SoundManager {
    public static GreenfootSound lobbyMusic = new GreenfootSound("lobbyMusic.mp3"); // music that plays everywhere but the game screen
    public static GreenfootSound bgm = new GreenfootSound("bgm.mp3"); // Background music for the playwithpet screen
    public static GreenfootSound click = new GreenfootSound("click.mp3"); // clicking sounds for all main menu buttons DO NOT USE FOR ACTIONS
    public static GreenfootSound toy = new GreenfootSound("toy.wav"); // give toy button

    private static boolean lobbyMusicPlaying = false;
    public static void playLobbyMusic() {
        if (!lobbyMusicPlaying) {
            lobbyMusic.playLoop();
            lobbyMusicPlaying = true;
        }
    }

    public static void playBgm(){
        bgm.playLoop();
    }

    public static void playClick() {
        Greenfoot.playSound("click.mp3");
    }
    public static void stopBgm(){
        bgm.stop();
    }
    public static void stopAll() {
        lobbyMusic.stop();
    }
}