package forest.view.renderer.console;

import forest.view.render.brunch.Brunch;
import forest.view.render.brunch.RendererBase;

public class BrunchRenderer extends RendererBase 
{
	@Override
	protected void drawInternal(Brunch aBrunch)
	{
        System.out.println(aBrunch.node.getParent().getText() + " -- " + aBrunch.node.getText());
	}
}
