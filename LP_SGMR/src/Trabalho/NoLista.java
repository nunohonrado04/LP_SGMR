package Trabalho;

public class NoLista 
{
	private int valor;
	private NoLista seguinte;
	
	public int getValor() 
	{
		return valor;
	}//getValor

	public void setValor(int valor) 
	{
		this.valor = valor;
	}//setValor

	public NoLista getSeguinte() 
	{
		return seguinte;
	}//getSeguinte

	public void setSeguinte(NoLista seguinte) 
	{
		this.seguinte = seguinte;
	}//setSeguinte

	public NoLista(int valor) 
	{
		this.valor = valor;
		seguinte = null;
	}//NoLista

	public NoLista(int valor, NoLista seguinte) 
	{
		this.valor = valor;
		this.seguinte = seguinte;
	}//NoLista
	
}//NoLista
