package forest.view.renderer.swing;

import forest.view.render.reef.Reef;

import javax.swing.JComponent;
import java.awt.Graphics;

public class ReefRenderer extends forest.view.render.reef.RendererBase 
{
    /*
     * このJComponentに図形を表示する
     */
    private JComponent parentJComponent;

    public ReefRenderer(JComponent parentJComponent)
    {
        this.parentJComponent = parentJComponent;
    }

    @Override
    protected void drawInternal(Reef aReef) 
    {
        Graphics gra = parentJComponent.getGraphics();

        int height = 15;
        int maxY = parentJComponent.getBounds().height - height;
        
        gra.drawString(
            aReef.getText(), 
            Utility.getX(aReef),
            Utility.getY(aReef, parentJComponent.getBounds().y, maxY));

        gra.drawRect(
            Utility.getX(aReef), 
            Utility.getY(aReef, 0, maxY) - 12, 
            Utility.getWidth(aReef.getText().length()),
            height);
    }
}
