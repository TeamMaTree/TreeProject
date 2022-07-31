package forest.view.render.root;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import forest.view.render.GenericRenderable;
import forest.Vector2;
import forest.view.render.Node;
import forest.view.render.reef.Reef;

public class Root implements Node, GenericRenderable<RendererBase>
{
    protected List<Reef> children = new ArrayList<>();
    protected RendererBase renderer;
    protected Vector2 position;
    protected String text;

    public Root(String text)
    {
        this.text = text;
    }

    @Override
    public Vector2 GetPosition()
    {
        return position;
    }

    @Override
    public String GetText()
    {
        return text;
    }

    @Override
    public void AddChild(Reef reef)
    {
        children.add(reef);
    }

    @Override
    public int GetIndent()
    {
        return 0;
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
    
    @Override
    public Node GetParent()
    {
        return null;
    }
    
    @Override
    public List<Reef> GetReadonlyChildren()
    {
        return Collections.unmodifiableList(children);
    }

    @Override
    public int GetIndex()
    {
        return 0;
    }
}
