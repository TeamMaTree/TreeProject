package forest;

import java.util.function.Consumer;

public class OnDragSubject implements Observable<DragData>
{
	private DragData dragData;

	@Override
	public void Attach(Consumer<DragData> func) 
	{

	}

	@Override
	public void Notify(DragData dragData) 
	{

	}

	@Override
	public void Disattach(Consumer<DragData> func) 
	{
	
	}
}
