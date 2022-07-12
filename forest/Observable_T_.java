public interface Observable_T_ {

	private DragData dragData;

	public abstract void Attach(Consumer<T> func);

	public abstract void Notify(T dragData);

	public abstract void Disattach(Consumer func);

}
