package forest.view.render.reef;

public abstract class RendererBase
{
    void draw(Reef aReef)
    {
        drawInternal(aReef);
    }
    
    /**
     * Reefを描画する
     */
    protected abstract void drawInternal(Reef aReef);
}