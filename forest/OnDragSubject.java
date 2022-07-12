public class OnDragSubject implements Observable_T_ {

	private DragData dragData;

	public void Attach(Consumer<DragData> func) {

	}

	public void Notify(DragData dragData) {

	}

	public void Disattach(Consumer func) {

	}


	/**
	 * @see Observable<T>#Attach()
	 *  
	 */
	public void Attach(Consumer<T> func) {

	}


	/**
	 * @see Observable<T>#Notify(T)
	 *  
	 */
	public void Notify(T dragData) {

	}

}
