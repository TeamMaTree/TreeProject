package forest.view.render;

import forest.Vector2;
import forest.view.render.reef.Reef;
import java.util.List;

public interface Node
{
    public Vector2 GetPosition();
    public String GetText();
    public Node GetParent();
    public List<Reef> GetReadonlyChildren();
    public int GetIndex();
    public void AddChild(Reef reef);
    public int GetIndent();
}
