public class Celula <NoBinTree>{
	
	private NoBinTree elemento;
	private Celula<NoBinTree> anterior;
	private Celula<NoBinTree> proximo;
	
	public NoBinTree getElemento() {
		return elemento;
	}
	public void setElemento(NoBinTree elemento) {
		this.elemento = elemento;
	}
	
	public Celula<NoBinTree> getAnterior() {
		return anterior;
	}
	public void setAnterior(Celula<NoBinTree> anterior) {
		this.anterior = anterior;
	}
	public Celula<NoBinTree> getProximo() {
		return proximo;
	}
	public void setProximo(Celula<NoBinTree> proximo) {
		this.proximo = proximo;
	}
	
	public Celula() {
	}
	
	public Celula(NoBinTree elemento) {
		super();
		this.elemento = elemento;
		this.proximo = null;
	}
	
	public Celula(NoBinTree elemento, Celula<NoBinTree> proximo) {
		super();
		this.elemento = elemento;
		this.proximo = proximo;
	}
	
	public Celula(NoBinTree elemento, Celula<NoBinTree> anterior, Celula<NoBinTree> proximo) {
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
