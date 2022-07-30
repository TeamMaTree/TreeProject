package forest.view.renderer.swing;

import forest.view.render.root.Root;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import java.awt.Color;

import forest.view.render.root.RendererBase;

public class RootRenderer extends RendererBase 
{
	private JComponent parentJComponent;

    public RootRenderer(JComponent parentJComponent)
	{
		this.parentJComponent = parentJComponent;
	}

	@Override
	protected void DrawInternal(Root aRoot) 
	{
        int height = 15;
        int maxY = parentJComponent.getBounds().height - height;

        JLabel label = new JLabel(aRoot.GetText());
        label.setBorder(new LineBorder(Color.BLACK, 1, true));

        label.setBounds(0, maxY / 2, getWidth(label.getText().length()), height);

        parentJComponent.add(label);
	}

    private int getWidth(int stringCount)
    {
        return stringCount * 8;
    }
}
