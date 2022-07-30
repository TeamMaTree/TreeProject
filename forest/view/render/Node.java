package forest.view.render;

import forest.Vector2;
import forest.view.render.reef.Reef;
import java.util.List;

public interface Node
{
    public Vector2 GetPosition();
    public String GetText();
    public Reef CreateReef(String test);
    public Node GetParent();
    public List<Reef> GetReadonlyChildren();
    public int GetIndex();
}
