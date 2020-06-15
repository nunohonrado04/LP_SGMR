package Trabalho;
import java.util.EmptyStackException;

public class ArrayPilha implements Pilha {

	private int[] dados;
	
	public ArrayPilha() 
	{
		dados = new int[]{};
	}//ArrayPilha
	
	@Override
	public void colocar(int i) 
	{
		deslocarDireita();
		dados[0]= i;
	}//colocar

	@Override
	public int retirar() 
	{
		if( estaVazia() ) 
		{ 
			throw new EmptyStackException();
		}
		
		int primeiro = dados[0];
		deslocarEsquerda();
		return primeiro;
	}//retirar

	@Override
	public int obter() 
	{
		if( estaVazia() ) 
		{ 
			throw new EmptyStackException();
		}
		return dados[0];
	}//obter

	@Override
	public boolean estaVazia() {
		return dados.length == 0; 	
	}
	
	private void deslocarDireita() 
	{
		int[] novo = new int[dados.length + 1];
		int i=1;
		for(int numero: dados ) 
		{
			novo[i]=numero;
			i++;
		}
		dados = novo;
	}//deslocarDireita
	
	private void deslocarEsquerda()
	{
		int[] novo = new int[dados.length - 1];
		for(int i = 1; i < dados.length; i++ )
		{
			novo[i-1]=dados[i];
		}
		dados = novo;
	}//deslocarEsquerda

}//ArrayPilha
