
import java.io.File;

/**
 *
 * @author Grebell
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        musicPlayerForm musicPlayerForm = new musicPlayerForm();
        musicPlayerForm.setVisible(true);
        musicPlayerForm.setResizable(false);
        musicPlayerForm.setLocationRelativeTo(null);
            File f = new File("C:\\Users\\Justin\\Documents\\NetBeansProjects\\MusicPlayer");
            File[] matchingFiles = f.listFiles((File dir, String name) -> {
                if(name.endsWith("wav")){
                    System.out.println(name);
                }
                
                
                return(name.endsWith("wav"));
        });
    }
    
}
