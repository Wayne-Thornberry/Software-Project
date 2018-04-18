package controllers;

import javafx.scene.media.AudioClip;

public class ControllerAudio {
    private static AudioClip test;

    public ControllerAudio(){
        test = new AudioClip("file:audio/main_menu.mp3");
        test.setVolume(0.2);
        test.play();
    }

}
