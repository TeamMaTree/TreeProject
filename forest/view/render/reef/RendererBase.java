package forest.view.render.reef;

public abstract class RendererBase
{
    void Draw(Reef aReef)
    {
        DrawInternal(aReef);
    }
    
    /**
     * Reefを描画する
     */
    protected abstract void DrawInternal(Reef aReef);
}