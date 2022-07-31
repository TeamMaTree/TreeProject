package forest.view.render.brunch;

public abstract class RendererBase
{
    void draw(Brunch aBrunch)
    {
        drawInternal(aBrunch);
    }

    /**
     * Brunchを描画する
     */
    protected abstract void drawInternal(Brunch aBrunch);
}