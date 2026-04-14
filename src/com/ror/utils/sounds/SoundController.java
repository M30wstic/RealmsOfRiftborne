package com.ror.utils.sounds;

public class SoundController {
    private static SoundManager currentBGM;
    private static String currentPath = "";

    public static void playBGM(String path) {
        // Prevent restarting if the same song is already playing
        if (currentPath.equals(path) && currentBGM != null && currentBGM.isRunning()) {
            return;
        }

        stopBGM(); // Clean up old music

        currentBGM = new SoundManager();
        currentBGM.load(path);
        currentBGM.play(true);
        currentPath = path;
    }

    public static void playSFX(String path) {
        //for sfx, just takes a swing and its over
        SoundManager sfx = new SoundManager();
        sfx.load(path);
        sfx.play(false);
    }

    public static void stopBGM() {
        if (currentBGM != null) {
            currentBGM.stop();
        }
    }
}