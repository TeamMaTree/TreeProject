package forest.view.render.brunch;

import forest.view.render.GenericRenderable;
import forest.view.render.Node;

/*
 * 線
 */
public class Brunch implements GenericRenderable<RendererBase>
{
    public Node node;

    private RendererBase renderer;

    public Brunch(Node node)
    {
       this.node = node;
    }

    @Override
	public void update()
    {
        renderer.draw(this);
    }

    @Override
    public void setRenderer(RendererBase renderer)
    {
        this.renderer = renderer;
    }

    public Node getTargetNode()
    {
        return node;
    }
}
