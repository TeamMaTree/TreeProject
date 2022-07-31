package forest.view.renderer.console;

import forest.view.render.reef.Reef;
import forest.view.render.reef.RendererBase;

public class ReefRenderer extends RendererBase 
{
	@Override
	protected void drawInternal(Reef aReef) 
	{
		for(int i = 0; i < aReef.getIndent(); i++) System.out.print(" ");
        System.out.println(aReef.getText());
	}
}
