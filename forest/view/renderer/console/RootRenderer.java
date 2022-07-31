package forest.view.renderer.console;

import forest.view.render.root.Root;
import forest.view.render.root.RendererBase;

public class RootRenderer extends RendererBase
{
	@Override
	protected void drawInternal(Root aRoot) 
	{
        System.out.println(aRoot.getText());
	}
}
