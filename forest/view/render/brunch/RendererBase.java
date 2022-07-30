package forest.view.render.brunch;

public abstract class RendererBase
{
    void Draw(Brunch aBrunch)
    {
        DrawInternal(aBrunch);
    }

    /**
     * Brunchを描画する
     */
    protected abstract void DrawInternal(Brunch aBrunch);
}