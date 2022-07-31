package forest.view.renderer.swing;

import forest.view.render.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Utility 
{
    public static int getY(Node node, int minY, int maxY)
    {
        List<Integer> separates = new ArrayList<>();
        List<Integer> indexs = new ArrayList<>();
        
        Node parentNode = node;

        for (int i = 0; i < node.GetIndent(); i++)
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

    public static int getX(Node node)
    {
        int strCount = 0;
        Node parentNode = node;

        for (int i = 0; i < node.GetIndent(); i++)
        {
            parentNode = parentNode.GetParent();

            strCount += parentNode.GetText().length() + 2;
        }
        
        return getWidth(strCount);
    }

    public static int getWidth(int stringCount)
    {
        return stringCount * 10;
    }
}
