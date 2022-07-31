package forest.view.render.root;

public abstract class RendererBase
{
    void draw(Root aRoot)
    {
        drawInternal(aRoot);
    }

    /**
     * Rootを描画する
     */
    protected abstract void drawInternal(Root aRoot);
}