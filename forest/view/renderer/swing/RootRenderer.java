package forest.view.renderer.swing;

import forest.view.render.root.Root;
import forest.view.render.root.RendererBase;

import javax.swing.JComponent;
import java.awt.Graphics;

public class RootRenderer extends RendererBase 
{
    /*
     * このJComponentに図形を表示する
     */
    private JComponent parentJComponent;

    public RootRenderer(JComponent parentJComponent)
    {
        this.parentJComponent = parentJComponent;
    }

    @Override
    protected void drawInternal(Root aRoot)
    {
        Graphics gra = parentJComponent.getGraphics();

        int height = 15;
        int maxY = parentJComponent.getBounds().height - height;

        gra.drawString(aRoot.getText(), 0, maxY / 2);
        gra.drawRect(0, (maxY / 2) - 12, Utility.getWidth(aRoot.getText().length()), height);
    }
}
