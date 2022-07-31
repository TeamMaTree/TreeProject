package forest;

import forest.controller.Controller;
import java.io.IOException;

public class Main 
{
    public static void main(String[] arguments) throws IOException 
    {
        Controller controller = new Controller();
        controller.open();
    }
}
