package forest.view.render.reef;

import forest.view.render.GenericRenderable;
import forest.view.render.root.Root;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import forest.view.render.Node;

/*
 * 葉
 */
public class Reef implements Node, GenericRenderable<RendererBase>
{
    private List<Reef> children = new ArrayList<>();
    private Node parent;
    private RendererBase renderer;
    private String text;

    public Reef(Node parent, String text)
    {
        this.text = text;
        this.parent = parent;
        parent.addChild(this);
    }

    @Override
    public String getText()
    {
        return text;
    }

    @Override
    public int getIndent()
    {
        int indent = 1;
        Node parentNode = parent;
        Node nextParentNode = parentNode.getParent();
        
        while (nextParentNode != null)
        {
            indent++;
            parentNode = nextParentNode;
            nextParentNode = parentNode.getParent();
        }

        return indent;
    }

    @Override
    public void addChild(Reef reef)
    {
        children.add(reef);
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
        return parent;
    }
    
    public Root getRoot()
    {
        Node parentNode = parent;

        int indent = getIndent();
        for (int i = 0; i < indent; i++) parentNode = parentNode.getParent();

        return (Root)parentNode;
    }

    @Override
    public int getIndex()
    {
        int result = 0;
        List<Reef> parentsChildren = parent.getReadonlyChildren();
        for(; result < parentsChildren.size(); result++)
        {
            if (parentsChildren.get(result) == this) break;
        }
        return result;
    }
    
    @Override
    public List<Reef> getReadonlyChildren()
    {
        return Collections.unmodifiableList(children);
    }
}
