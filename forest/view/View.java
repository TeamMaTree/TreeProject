package forest.view;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import forest.Animator;
import forest.controller.Controller;
import forest.model.Model;
import forest.view.render.Renderable;
import forest.view.render.brunch.Brunch;
import forest.view.render.reef.Reef;

public class View 
{
    private Model model;

    private Controller controller;

    //private Observable observable;

    List<Renderable> rens = new ArrayList<>();
    private Animator animator;

    public View(Model aModel) 
    {
        this.model = aModel;
    }

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

        model.root.SetRenderer(new forest.view.renderer.swing.RootRenderer(mainPanel));
        rens.add(model.root);
        
        for (Reef reef : model.reefs) 
        {
            reef.SetRenderer(new forest.view.renderer.swing.ReefRenderer(mainPanel));
            rens.add(reef);
        }

        for (Brunch brunch : model.brunchs) 
        {
            brunch.SetRenderer(new forest.view.renderer.swing.BrunchRenderer(mainPanel));
            rens.add(brunch);
        }
        
        for (Renderable renderable : rens) renderable.Update();
    }

    public void PlayAnimation() 
    {

    }
}
