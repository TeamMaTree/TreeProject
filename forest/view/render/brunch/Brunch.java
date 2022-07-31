package forest.view.render.brunch;

import forest.view.render.GenericRenderable;
import forest.view.render.Node;

public class Brunch implements GenericRenderable<RendererBase>
{
    public Node node;

    private RendererBase renderer;

    public Brunch(Node node)
    {
       this.node = node;
    }

    @Override
	public void Update()
    {
        renderer.Draw(this);
    }

    @Override
    public void SetRenderer(RendererBase renderer)
    {
        this.renderer = renderer;
    }

    public Node GetTargetNode()
    {
        return node;
    }
}
