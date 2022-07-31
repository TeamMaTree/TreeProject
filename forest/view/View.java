package forest.view;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import forest.model.Model;
import forest.view.render.Renderable;
import forest.view.render.brunch.Brunch;
import forest.view.render.reef.Reef;

/*
 * ビュー
 */
public class View 
{
    /*
     * 表示する対象のモデル
     */
    private Model model;
    /*
     * 表示する物のリスト
     */
    private List<Renderable> rens = new ArrayList<>();

    public View(Model aModel) 
    {
        this.model = aModel;
    }

    /*
     * 表示する
     */
    public void Show() 
    {
        JFrame aWindow = new JFrame("Forest");

        aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aWindow.addNotify();
        int titleBarHeight = aWindow.getInsets().top;
        Point aPoint = new Point(1000, 1000);
        aWindow.setMinimumSize(new Dimension(aPoint.x, aPoint.y + titleBarHeight));
        aWindow.setResizable(false);
        aWindow.setSize(aPoint.x, aPoint.y + titleBarHeight);
        aWindow.setLocation(100, 100);

        JPanel mainPanel = new JPanel(null);
        mainPanel.setBounds(0, 0, aWindow.getWidth(), aWindow.getHeight() - 28);

        aWindow.add(mainPanel);
        aWindow.setVisible(true);
        aWindow.toFront();

        model.getRoot().setRenderer(new forest.view.renderer.swing.RootRenderer(mainPanel));
        //model.getRoot().setRenderer(new forest.view.renderer.console.RootRenderer());
        rens.add(model.getRoot());
        
        for (Reef reef : model.getReefList()) 
        {
            reef.setRenderer(new forest.view.renderer.swing.ReefRenderer(mainPanel));
            //reef.setRenderer(new forest.view.renderer.console.ReefRenderer());
            rens.add(reef);
        }

        for (Brunch brunch : model.getBrunchList()) 
        {
            brunch.setRenderer(new forest.view.renderer.swing.BrunchRenderer(mainPanel));
            //brunch.setRenderer(new forest.view.renderer.console.BrunchRenderer());
            rens.add(brunch);
        }
        
        for (Renderable renderable : rens) renderable.update();
    }
}
