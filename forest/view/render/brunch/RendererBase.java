package forest.view.render.brunch;

public abstract class RendererBase
{
    void Draw(Brunch aBrunch)
    {
        DrawInternal(aBrunch);
    }

    protected abstract void DrawInternal(Brunch aBrunch);
}