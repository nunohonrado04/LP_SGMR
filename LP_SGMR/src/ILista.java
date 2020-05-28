public interface ILista<E> {

	public void insert(E e);
	
	public void insertAfter(E prev, E e);
	
	public void insertBefore(E next, E e);

	public void delete(E e);


}
