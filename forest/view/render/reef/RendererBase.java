package forest.view.render.reef;

public abstract class RendererBase
{
    void Draw(Reef aReef)
    {
        DrawInternal(aReef);
    }

    protected abstract void DrawInternal(Reef aReef);
}