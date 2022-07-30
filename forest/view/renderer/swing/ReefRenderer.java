package forest.view.renderer.swing;

import forest.view.render.Node;
import forest.view.render.reef.Reef;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReefRenderer extends forest.view.render.reef.RendererBase 
{
    private JComponent parentJComponent;

    public ReefRenderer(JComponent parentJComponent)
    {
        this.parentJComponent = parentJComponent;
    }

    @Override
    protected void DrawInternal(Reef aReef) 
    {
        int height = 15;
        int maxY = parentJComponent.getBounds().height - height;

        JLabel label = new JLabel(aReef.GetText());
        label.setBorder(new LineBorder(Color.BLACK, 1, true));

        label.setBounds(getX(aReef), getY(aReef, 0, maxY), getWidth(label.getText().length()), height);

        parentJComponent.add(label);
    }
    
    private int getY(Reef aReef, int minY, int maxY)
    {
        List<Integer> separates = new ArrayList<>();
        List<Integer> indexs = new ArrayList<>();
        
        Node parentNode = aReef;

        for (int i = 0; i < aReef.GetIndent(); i++)
        {
            indexs.add(parentNode.GetIndex());
            parentNode = parentNode.GetParent();
            separates.add(parentNode.GetReadonlyChildren().size());
        }

        Collections.reverse(separates);
        Collections.reverse(indexs);

        for (int i = 0; i < separates.size(); i++)
        {
            int spaceY = maxY - minY;
            int elementY = spaceY / separates.get(i);

            minY =  elementY * indexs.get(i) + minY;
            maxY =  minY + elementY;
        }

        return (maxY - minY) / 2 + minY;
    }

    private int getX(Reef aReef)
    {
        int strCount = 0;
        
        Node parentNode = aReef.GetParent();
        Node nextParentNode = parentNode.GetParent();

        strCount += parentNode.GetText().length() + 2;
        
        while (nextParentNode != null)
        {
            parentNode = nextParentNode;
            nextParentNode = parentNode.GetParent();

            strCount += parentNode.GetText().length() + 2;
        }

        return getWidth(strCount);
    }

    private int getWidth(int stringCount)
    {
        return stringCount * 8;
    }
}
