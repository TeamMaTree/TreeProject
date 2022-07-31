package forest.view.render;

public interface GenericRenderable<RenderType> extends Renderable 
{
    /*
     * レンダラーを登録する
     */
	public abstract void setRenderer(RenderType renderer);
}
