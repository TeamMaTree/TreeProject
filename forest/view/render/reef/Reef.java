package forest.view.render.reef;

import forest.view.render.GenericRenderable;
import forest.view.render.root.Root;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import forest.Vector2;
import forest.view.render.Node;

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
    }

    @Override
    public Vector2 GetPosition()
    {
        return null;
    }

    @Override
    public String GetText()
    {
        return text;
    }

    public int GetIndent()
    {
        int indent = 1;
        Node parentNode = parent;
        Node nextParentNode = parentNode.GetParent();
        
        while (nextParentNode != null)
        {
            indent++;
            parentNode = nextParentNode;
            nextParentNode = parentNode.GetParent();
        }

        return indent;
    }

    @Override
    public Reef CreateReef(String text)
    {
        Reef result = new Reef(this, text);
        children.add(result);
        return result;
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
        return parent;
    }
    
    public Root GetRoot()
    {
        Node parentNode = parent;

        int indent = GetIndent();
        for (int i = 0; i < indent; i++) parentNode = parentNode.GetParent();

        return (Root)parentNode;
    }

    @Override
    public int GetIndex()
    {
        int result = 0;
        List<Reef> parentsChildren = parent.GetReadonlyChildren();
        for(; result < parentsChildren.size(); result++)
        {
            if (parentsChildren.get(result) == this) break;
        }
        return result;
    }
    
    @Override
    public List<Reef> GetReadonlyChildren()
    {
        return Collections.unmodifiableList(children);
    }
}
