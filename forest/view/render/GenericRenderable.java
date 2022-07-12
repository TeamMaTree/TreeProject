package forest.view.render;

public interface GenericRenderable<RenderType> extends Renderable 
{
	public abstract void SetRenderer(RenderType renderer);
}
