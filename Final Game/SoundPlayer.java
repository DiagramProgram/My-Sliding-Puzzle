import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;

public class SoundPlayer {
  public static void main (String args[]) {
    new SoundPlayer ();
  }
  
  public SoundPlayer () {
    playSound ("GameMusic.wav");
  }
  
  public void playSound(String audioFileName) {
    try {
      AudioInputStream audioIn = AudioSystem.getAudioInputStream(SoundPlayer.class.getResource(audioFileName));
      
      Clip clip = AudioSystem.getClip();
      
      clip.open(audioIn);
      clip.loop(Clip.LOOP_CONTINUOUSLY);
      Thread.sleep(10000);
    } catch (Exception ex) {
      System.out.println("ERROR! SOMETHING IS WRONG! FIX IT!");
    }
  }
}