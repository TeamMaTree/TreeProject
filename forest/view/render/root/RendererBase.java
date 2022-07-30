package forest.view.render.root;

public abstract class RendererBase
{
    void Draw(Root aRoot)
    {
        DrawInternal(aRoot);
    }

    /**
     * Rootを描画する
     */
    protected abstract void DrawInternal(Root aRoot);
}