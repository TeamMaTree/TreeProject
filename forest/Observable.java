package forest;

import java.util.function.Consumer;

public interface Observable<T>
{
	public abstract void Attach(Consumer<T> func);

	public abstract void Notify(T dragData);

	public abstract void Disattach(Consumer<T> func);
}
