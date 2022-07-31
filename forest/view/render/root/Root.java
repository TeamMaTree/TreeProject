package forest.view.render.root;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import forest.view.render.GenericRenderable;
import forest.view.render.Node;
import forest.view.render.reef.Reef;

public class Root implements Node, GenericRenderable<RendererBase>
{
    protected List<Reef> children = new ArrayList<>();
    protected RendererBase renderer;
    protected String text;

    public Root(String text)
    {
        this.text = text;
    }

    @Override
    public String getText()
    {
        return text;
    }

    @Override
    public void addChild(Reef reef)
    {
        children.add(reef);
    }

    @Override
    public int getIndent()
    {
        return 0;
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
    
    @Override
    public Node getParent()
    {
        return null;
    }
    
    @Override
    public List<Reef> getReadonlyChildren()
    {
        return Collections.unmodifiableList(children);
    }

    @Override
    public int getIndex()
    {
        return 0;
    }
}
