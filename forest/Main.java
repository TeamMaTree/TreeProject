package forest;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import forest.view.View;
import forest.model.Model;
import java.io.IOException;

public class Main 
{
    public static void main(String[] arguments) throws IOException 
    {
        JFrame aWindow = new JFrame("Forest");
        JFileChooser filechooser = new JFileChooser();
        filechooser.setFileFilter(new FileNameExtensionFilter("*.txt", "txt")); 
        filechooser.showOpenDialog(aWindow);

        Model model = new Model(filechooser.getSelectedFile());

        View view = new View(model);
        view.Show();
    }
}
