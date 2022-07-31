package forest.controller;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import forest.view.View;
import forest.model.Model;
import java.io.IOException;

/*
 * コントローラー
 */
public class Controller 
{
    /*
     * 対象のモデル
     */
    private Model model;
    /*
     * 対象のビュー
     */
    private View view;

    /*
     * コントローラのコンストラクタ
     */
    public Controller() throws IOException 
    {
        JFrame aWindow = new JFrame("Forest");
        JFileChooser filechooser = new JFileChooser();
        filechooser.setFileFilter(new FileNameExtensionFilter("*.txt", "txt")); 
        filechooser.showOpenDialog(aWindow);

        model = new Model(filechooser.getSelectedFile());
    }

    /*
     * 表示する
     */
    public void open()
    {
        view = new View(model);
        view.Show();
    }
}
