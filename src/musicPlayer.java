import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Grebell
 */
public class musicPlayer {
        
    
    static musicPlayer player = new musicPlayer();
    
    static Clip clip;
    
    private musicPlayer()
    {
        
    }
    public static musicPlayer getInstance(){
    return player;
    }
    public static void loadMusic (String filepath)
    {
        try{
        File musicPath = new File(filepath);
        
        if(musicPath.exists()){
        AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
        clip = AudioSystem.getClip();
        clip.open(audioInput);
        }    
    }
    catch(IOException | LineUnavailableException | UnsupportedAudioFileException e){
    System.out.println(e);
    }
    }
}
