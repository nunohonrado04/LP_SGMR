public class Celula <E>{
	
	private E elemento;
	private Celula<E> anterior;
	private Celula<E> proximo;
	
	public E getElemento() {
		return elemento;
	}
	public void setElemento(E elemento) {
		this.elemento = elemento;
	}
	
	public Celula<E> getAnterior() {
		return anterior;
	}
	public void setAnterior(Celula<E> anterior) {
		this.anterior = anterior;
	}
	public Celula<E> getProximo() {
		return proximo;
	}
	public void setProximo(Celula<E> proximo) {
		this.proximo = proximo;
	}
	
	public Celula() {
	}
	
	public Celula(E elemento) {
		super();
		this.elemento = elemento;
		this.proximo = null;
	}
	
	public Celula(E elemento, Celula<E> proximo) {
		super();
		this.elemento = elemento;
		this.proximo = proximo;
	}
	
	public Celula(E elemento, Celula<E> anterior, Celula<E> proximo) {
		super();
		this.elemento = elemento;
		this.anterior = anterior;
		this.proximo = proximo;
	}
	
	@Override
	public String toString() {
		return "Celula [elemento=" + elemento + ", anterior=" + anterior + ", proximo=" + proximo + "]";
	}
	
	
}
