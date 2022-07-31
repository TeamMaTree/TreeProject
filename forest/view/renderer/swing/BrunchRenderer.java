package forest.view.renderer.swing;

import forest.view.render.brunch.Brunch;
import forest.view.render.brunch.RendererBase;

import javax.swing.JComponent;
import java.awt.Graphics;

import forest.view.render.Node;

public class BrunchRenderer extends RendererBase 
{
    private JComponent parentJComponent;

    public BrunchRenderer(JComponent parentJComponent)
    {
        this.parentJComponent = parentJComponent;
    }

    @Override
    protected void DrawInternal(Brunch aBrunch) 
    {
        int height = 15;
        int maxY = parentJComponent.getBounds().height - height;

        Graphics gra = parentJComponent.getGraphics();
        
        gra.drawLine(
            Utility.getX(aBrunch.GetTargetNode()),                                                                                
            Utility.getY(aBrunch.GetTargetNode(), parentJComponent.getBounds().y, maxY) - 4,
            Utility.getX(aBrunch.GetTargetNode().GetParent()) + Utility.getWidth(aBrunch.GetTargetNode().GetParent().GetText().length()), 
            Utility.getY(aBrunch.GetTargetNode().GetParent(), parentJComponent.getBounds().y, maxY) - 4);
    }
}
