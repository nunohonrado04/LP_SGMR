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

	public int getValor() 
	{
		return valor;
	}//getValor
	
	public void setValor(int valor) 
	{
		this.valor = valor;
	}//setValor
	
	public LocalTime getHora() 
	{
		return hora;
	}//getHora
	
	public void setHora(LocalTime hora) 
	{
		this.hora = hora;
	}//setHora
	
	public boolean isMarcada() 
	{
		return marcada;
	}//isMarcada
	
	public void setMarcada(boolean marcada) 
	{
		this.marcada = marcada;
	}//setMarcada
	
	public boolean isOcupada() 
	{
		return ocupada;
	}//isOcupada
	
	public void setOcupada(boolean ocupada) 
	{
		this.ocupada = ocupada;
	}//setOcupada
	
	public NoBinTree getFilhoEsquerda() 
	{
		return filhoEsquerda;
	}//getFilhoEsquerda
	
	public void setFilhoEsquerda(NoBinTree filhoEsquerda) 
	{
		this.filhoEsquerda = filhoEsquerda;
	}//setFilhoEsquerda
	
	public NoBinTree getFilhoDireita() 
	{
		return filhoDireita;
	}//getFilhoDireita
	
	public void setFilhoDireita(NoBinTree filhoDireita) 
	{
		this.filhoDireita = filhoDireita;
	}//setFilhoDireita
	
	public NoBinTree(int valor) 
	{
		this.valor = valor;
		this.hora = null;
		this.marcada = false;
		this.ocupada = false;
		this.filhoEsquerda = null;
		this.filhoDireita = null;
	}//NoBinTree
	
	@Override
	public String toString() 
	{
		return String.format("[%d] ",  this.valor );
	}//toString
	
}//NoBinTree
