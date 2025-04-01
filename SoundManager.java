import greenfoot.*;

public class SoundManager {
    public static GreenfootSound lobbyMusic = new GreenfootSound("lobbyMusic.mp3");
    private static boolean lobbyMusicPlaying = false;
    public static void playLobbyMusic() {
        if (!lobbyMusicPlaying) {
            lobbyMusic.playLoop();
            lobbyMusicPlaying = true;
        }
    }

    public static void playClick() {
        Greenfoot.playSound("click.mp3");
    }

    public static void stopAll() {
        lobbyMusic.stop();
    }
}