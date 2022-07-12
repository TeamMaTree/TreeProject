package forest.view.render;

import forest.Vector2;

public interface Node<RenderType> extends GenericRenderable<RenderType>
{
    public Vector2 GetPosition();
    public void GetIndent();
    public void AddChild();
}
