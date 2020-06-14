package Trabalho;

import java.time.LocalTime;

public class NoBinTree 
{
	private int valor;
	private LocalTime hora;
	private boolean marcada;
	private boolean ocupada;
	private NoBinTree filhoEsquerda;
	private NoBinTree filhoDireita;

	// Acessores 
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	public boolean isMarcada() {
		return marcada;
	}
	public void setMarcada(boolean marcada) {
		this.marcada = marcada;
	}
	public boolean isOcupada() {
		return ocupada;
	}
	public void setOcupada(boolean ocupada) {
		this.ocupada = ocupada;
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
	
	
	// Construtores
	public NoBinTree(int valor) {
		this.valor = valor;
		this.hora = null;
		this.marcada = false;
		this.ocupada = false;
		this.filhoEsquerda = null;
		this.filhoDireita = null;
	}
	
	// Override toString
	@Override
	public String toString() {
		return String.format("[%d] ",  this.valor );
	}
	
}
