import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class NoBinTree {
	
	private int nrMesa;

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
	LocalDateTime hora = LocalDateTime.now();

	private NoBinTree filhoEsquerda;
	private NoBinTree filhoDireita;


	// Acessores 
	public int getNrMesa() {
		return nrMesa;
	}
	public void setNrMesa(int nrMesa) {
		this.nrMesa = nrMesa;
	}
	public NoBinTree getFilhoEsquerda() {
		return filhoEsquerda;
	}
	public void setFilhoEsquerda(NoBinTree filhoEsquerda) {
		this.filhoEsquerda = filhoEsquerda;
	}
	public NoBinTree getFilhoDireita() {
		return filhoDireita;
	}
	public void setFilhoDireita(NoBinTree filhoDireita) {
		this.filhoDireita = filhoDireita;
	}
	public LocalDateTime getHora() {
		return hora;
	}
	public void setHora(LocalDateTime hora) {
		this.hora = hora;
	}


	// Construtores
	public NoBinTree(int nrMesa) {
		this.nrMesa=nrMesa;
		this.hora=null;
		this.filhoEsquerda = null;
		this.filhoDireita = null;
	}



	public int altura()
	{
		return altura(this);
	}
	
	public int altura(NoBinTree no)
	{
		if(no == null) {
			return 0;
		}
		
		int eAltura = altura(no.getFilhoEsquerda()); 
		
        int dAltura = altura(no.getFilhoDireita());
        
        return eAltura > dAltura ? eAltura+1 : dAltura+1;
	}
	
	// Override toString


	@Override
	public String toString() {
		return "NoBinTree{" +
				"nrMesa=" + nrMesa +
				", hora=" + hora +
				", filhoEsquerda=" + filhoEsquerda +
				", filhoDireita=" + filhoDireita +
				'}';
	}
}
