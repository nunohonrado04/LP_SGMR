package Trabalho;
import java.util.EmptyStackException;

public class ListPilha implements Pilha
{
	private NoLista top;

	public ListPilha() 
	{
		top = null;
	}//ListPilha

	@Override
	public void colocar(int i) 
	{
		NoLista novo = new NoLista(i, top);
		top = novo;
	}//colocar

	@Override
	public int retirar() 
	{
		if( estaVazia() ) 
		{ 
			System.out.println("N�o existe mesas!");
			throw new EmptyStackException();
		}
		
		int primeiro = top.getValor();
		top = top.getSeguinte();
		return primeiro;
	}//retirar

	@Override
	public int obter() 
	{
		if( estaVazia() ) 
		{ 
			System.out.println("N�o existe de momento mesas dispon�veis!");
			throw new EmptyStackException();
		}
		return top.getValor();
	}//obter

	@Override
	public boolean estaVazia() 
	{
		return top == null;
	}//estaVazia
	
}//ListPilha
