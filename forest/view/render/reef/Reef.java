package forest.view.render.reef;

import java.util.ArrayList;
import forest.Vector2;
import forest.view.render.Node;

public class Reef implements Node<RendererBase>
{
    private ArrayList<Node> children;
    private Node parent;

    private RendererBase renderer;

    public Reef(Node parent)
    {
        
    }

    @Override
    public Vector2 GetPosition()
    {
        return null;
    }

    @Override
    public void GetIndent()
    {

    }

    @Override
    public void AddChild()
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