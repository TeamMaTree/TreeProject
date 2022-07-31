package forest.view.renderer.swing;

import forest.view.render.brunch.Brunch;
import forest.view.render.brunch.RendererBase;

import javax.swing.JComponent;
import java.awt.Graphics;

public class BrunchRenderer extends RendererBase 
{
    /*
     * このJComponentに図形を表示する
     */
    private JComponent parentJComponent;

    public BrunchRenderer(JComponent parentJComponent)
    {
        this.parentJComponent = parentJComponent;
    }

    @Override
    protected void drawInternal(Brunch aBrunch) 
    {
        int height = 15;
        int maxY = parentJComponent.getBounds().height - height;

        Graphics gra = parentJComponent.getGraphics();
        
        gra.drawLine(
            Utility.getX(aBrunch.getTargetNode()),                                                                                
            Utility.getY(aBrunch.getTargetNode(), parentJComponent.getBounds().y, maxY) - 4,
            Utility.getX(aBrunch.getTargetNode().getParent()) + Utility.getWidth(aBrunch.getTargetNode().getParent().getText().length()), 
            Utility.getY(aBrunch.getTargetNode().getParent(), parentJComponent.getBounds().y, maxY) - 4);
    }
}
