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
import forest.view.render.Renderable;
import forest.view.render.reef.Reef;

public class View 
{
    private Model model;

    private Controller controller;

    //private Observable observable;

    private Animator animator;

    public void Show() 
    {
        JFrame aWindow = new JFrame("");

        aWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aWindow.addNotify();
        int titleBarHeight = aWindow.getInsets().top;
        Point aPoint = new Point(600, 400);
        aWindow.setMinimumSize(new Dimension(aPoint.x, aPoint.y + titleBarHeight));
        aWindow.setResizable(true);
        aWindow.setSize(aPoint.x, aPoint.y + titleBarHeight);
        aWindow.setLocation(100, 100);

        JPanel mainPanel = new JPanel(null);
        mainPanel.setBounds(0, 0, aWindow.getWidth(), aWindow.getHeight() - 28);

        List<Renderable> rens = new ArrayList<>();

        Root root = new Root("Root");
        root.SetRenderer(new forest.view.renderer.swing.RootRenderer(mainPanel));
        rens.add(root);

        Reef reef1 = root.CreateReef("Reeeeeeeeef1");
        reef1.SetRenderer(new forest.view.renderer.swing.ReefRenderer(mainPanel));
        rens.add(reef1);

        Reef reef2 = reef1.CreateReef("Reef2");
        reef2.SetRenderer(new forest.view.renderer.swing.ReefRenderer(mainPanel));
        rens.add(reef2);

        Reef reef3 = reef1.CreateReef("Reef3");
        reef3.SetRenderer(new forest.view.renderer.swing.ReefRenderer(mainPanel));
        rens.add(reef3);

        for(int i = 0; i < 5; i++)
        {
            Reef reef4 = reef2.CreateReef("Reef" + i);
            reef4.SetRenderer(new forest.view.renderer.swing.ReefRenderer(mainPanel));
            rens.add(reef4);
            for(int j = 0; j < 2; j++)
            {
                Reef reef5 = reef4.CreateReef("Reef" + j);
                reef5.SetRenderer(new forest.view.renderer.swing.ReefRenderer(mainPanel));
                rens.add(reef5);
            }
        }

        for(int j = 0; j < 2; j++)
        {
            Reef reef5 = reef3.CreateReef("Reef" + j);
            reef5.SetRenderer(new forest.view.renderer.swing.ReefRenderer(mainPanel));
            rens.add(reef5);
        }

        for (Renderable renderable : rens)
        {
            renderable.Update();
        }

        aWindow.add(mainPanel);
        aWindow.setVisible(true);
        aWindow.toFront();
    }

    public void PlayAnimation() 
    {

    }

    //public View(Model aModel) 
    {

    }
}
