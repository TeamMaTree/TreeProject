package forest.view;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import forest.Animator;
import forest.Observable;
import forest.controller.Controller;
import forest.model.Model;
import forest.view.render.root.Root;
import forest.view.render.Node;
import forest.view.render.Renderable;
import forest.view.render.brunch.Brunch;
import forest.view.render.reef.Reef;

public class View 
{
    private Model model;

    private Controller controller;

    //private Observable observable;

    private Animator animator;

    List<Renderable> rens = new ArrayList<>();
    
    public void Show() 
    {
        JFrame aWindow = new JFrame("Forest");

        aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aWindow.addNotify();
        int titleBarHeight = aWindow.getInsets().top;
        Point aPoint = new Point(600, 400);
        aWindow.setMinimumSize(new Dimension(aPoint.x, aPoint.y + titleBarHeight));
        aWindow.setResizable(false);
        aWindow.setSize(aPoint.x, aPoint.y + titleBarHeight);
        aWindow.setLocation(100, 100);

        JPanel mainPanel = new JPanel(null);
        mainPanel.setBounds(0, 0, aWindow.getWidth(), aWindow.getHeight() - 28);

        Root root = new Root("Root");
        root.SetRenderer(new forest.view.renderer.swing.RootRenderer(mainPanel));
        rens.add(root);
        AddReef(root, mainPanel, "a");
        AddReef(root, mainPanel, "a");

        Reef r = AddReef(root, mainPanel, "ab");
        AddReef(r, mainPanel, "ab");
        AddReef(r, mainPanel, "ab");

        Reef c = AddReef(r, mainPanel, "ac");
        AddReef(c, mainPanel, "ac");
        AddReef(c, mainPanel, "ac");

        Reef d = AddReef(r, mainPanel, "ad");
        AddReef(d, mainPanel, "ad");
        AddReef(d, mainPanel, "ad");

        aWindow.add(mainPanel);

        aWindow.setVisible(true);
        aWindow.toFront();
        
        for (Renderable renderable : rens) renderable.Update();
    }

    private Reef AddReef(Node parentNode, JPanel parentJPanel, String text)
    {
        Reef reef = new Reef(parentNode, text);
        reef.SetRenderer(new forest.view.renderer.swing.ReefRenderer(parentJPanel));

        Brunch brunch = new Brunch(reef);
        brunch.SetRenderer(new forest.view.renderer.swing.BrunchRenderer(parentJPanel));

        rens.add(reef);
        rens.add(brunch);

        return reef;
    }

    public void PlayAnimation() 
    {

    }

    //public View(Model aModel) 
    {

    }
}
