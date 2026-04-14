package com.ror.utils.sounds;

import java.net.URL;
import javax.sound.sampled.*;

public class SoundManager {
    private Clip clip;

    public void load(String path) {
        try {
            URL url = SoundManager.class.getResource(path);
            AudioInputStream baseIn = AudioSystem.getAudioInputStream(url);
            AudioFormat baseFormat = baseIn.getFormat();

            //by the grace of the almighty google, converts ogg to pcm for java to get it working
            AudioFormat decodedFormat = new AudioFormat(
                AudioFormat.Encoding.PCM_SIGNED,
                baseFormat.getSampleRate(),
                16,
                baseFormat.getChannels(),
                baseFormat.getChannels() * 2,
                baseFormat.getSampleRate(),
                false
            );

            AudioInputStream decodedIn = AudioSystem.getAudioInputStream(decodedFormat, baseIn);
            clip = AudioSystem.getClip();
            clip.open(decodedIn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void play(boolean loop) {
        if (clip != null) {
            clip.setFramePosition(0);
            if (loop) clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        }
    }

    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    public boolean isRunning() {
        return clip != null && clip.isRunning();
    }
}