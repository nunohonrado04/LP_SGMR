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
			System.out.println("Não existe mesas!");
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
			System.out.println("Não existe de momento mesas disponíveis!");
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
