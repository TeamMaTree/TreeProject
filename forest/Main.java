package forest;

import forest.controller.Controller;
import java.io.IOException;

/**
 * Forestプロジェクトのメインファイル
 */
public class Main 
{
    /**
     * controllerのインスタンスを作成して、
     * Forestアプリの実行が開始される。
     * @param arguments
     * @throws IOException
     */
    public static void main(String[] arguments) throws IOException 
    {
        Controller controller = new Controller();
        controller.open();
    }
}
