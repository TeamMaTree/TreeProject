package forest.view.render.brunch;

import forest.view.render.GenericRenderable;
import forest.view.render.Node;

public class Brunch implements GenericRenderable<RendererBase>
{
    public Node node1;
    public Node node2;

    private RendererBase renderer;

    public Brunch(Node node1, Node node2)
    {
       
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
}
