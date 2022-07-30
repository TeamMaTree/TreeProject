package forest.view.renderer.swing;

import forest.view.render.root.Root;

import javax.swing.JComponent;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import forest.view.render.root.RendererBase;

public class RootRenderer extends RendererBase 
{
	private JComponent jComponent;

    public RootRenderer(JComponent targetJComponent)
	{
		this.jComponent = targetJComponent;
	}

	@Override
	protected void DrawInternal(Root aRoot) 
	{
        Graphics g2 = (Graphics)jComponent.getGraphics();
		g2.drawRect(100,100,50,50);//矩形
	}
}
