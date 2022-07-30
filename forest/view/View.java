package forest.view;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.util.ArrayList;
import java.util.function.Consumer;

import forest.Animator;
import forest.Observable;
import forest.controller.Controller;
import forest.model.Model;
import forest.view.render.root.Root;

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

	    JPanel mainPanel = new JPanel(new GridBagLayout());
	    aWindow.add(mainPanel);

	    aWindow.setVisible(true);
	    aWindow.toFront();

        Root root = new Root();
		root.SetRenderer(new forest.view.renderer.swing.RootRenderer(mainPanel));
		//root.SetRenderer(new forest.view.renderer.console.RootRenderer());
		root.Update();
	}

	public void PlayAnimation() 
	{

	}

	//public View(Model aModel) 
	{

	}
}
