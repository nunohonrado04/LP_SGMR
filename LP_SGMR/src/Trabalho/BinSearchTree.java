package Trabalho;

import java.time.LocalTime;
import java.util.LinkedList;


public class BinSearchTree 
{
	private NoBinTree raiz;
	// -------------------------------------------- InserirMesa -------------------------------------------------
	public void inserirMesa( int num ) 
	{
		if( raiz == null ) 
		{
			NoBinTree novo = new NoBinTree(num);
			raiz = novo;
		}
		else
			inserir(num, raiz);			
	}
	
	private void inserir( int num, NoBinTree pai ) 
	{
		if( pai.getValor() > num ) 
		{
			// Segue pela esquerda
			if( pai.getFilhoEsquerda() == null) 
			{
				NoBinTree novo = new NoBinTree(num);
				pai.setFilhoEsquerda(novo);
			}
			else
				inserir( num, pai.getFilhoEsquerda() );
		}
		else if(  pai.getValor() < num ) 
			{
				// Segue pela direita
				if( pai.getFilhoDireita() == null) 
				{
					NoBinTree novo = new NoBinTree(num);
					pai.setFilhoDireita(novo);
				}
				else
					inserir( num, pai.getFilhoDireita() );
			}
			else
			{
				// num È igual a pai.getValor(), 
				// n„o s„o permitidos duplicados
			
				throw new IllegalArgumentException("n„o s„o permitidos valores duplicados !");	
			}		
	}
	
	// -------------------------------------------- Procurar -------------------------------------------------
	public NoBinTree procurar( int num ) 
	{
		if( raiz == null ) 
		{
			return null;
		}
		else
			return procurar(num, raiz);
	}
	
	private NoBinTree procurar( int num, NoBinTree no ) 
	{
		if( no == null )
			return null;
		
		if( no.getValor() == num )
			return no;
		
		if( no.getValor() > num ) 
		{
			// Segue pela esquerda
			return procurar( num, no.getFilhoEsquerda() );
		}
		else  
		{
			// Segue pela direita
			return procurar( num, no.getFilhoDireita() );
		}
	
	}
	
	// -------------------------------------------- PreOrder -------------------------------------------------
	private void visita( NoBinTree no, LinkedList<NoBinTree> nosVisitados, Lista ordemChegada )
	{
		//System.out.println(no.getHora());
		if(no.getHora()!=null) {
			//System.out.println("\nN„o È null");
			ordemChegada.push(no);
		}
		//System.out.println("\n… null");
		nosVisitados.add(no);
	}

	public Lista preOrder() 
	{
		LinkedList<NoBinTree> nosVisitados = new LinkedList<NoBinTree>();
		Lista ordemChegada = new Lista();
		
		preOrder(raiz, nosVisitados,ordemChegada);
		
		
		return ordemChegada;
	}
	
	private void preOrder( NoBinTree no, LinkedList<NoBinTree> nosVisitados, Lista ordemChegada )
	{
		if( no == null)
			return;
		
		visita(no, nosVisitados, ordemChegada);
		preOrder( no.getFilhoEsquerda(), nosVisitados, ordemChegada );
		preOrder( no.getFilhoDireita(), nosVisitados, ordemChegada );
		
	}
	// -------------------------------------------- InserirComDistanciaEntreMesas -------------------------------------
	public void inserirComDistanciaEntreMesas(NoBinTree no)
	{
		if( raiz == null ) 
		{
			NoBinTree novo = new NoBinTree(no.getValor());
			raiz = novo;
		}
		else
			inserirComDistanciaEntreMesas(no.getValor(), raiz);
	}
	
	private void inserirComDistanciaEntreMesas( int num, NoBinTree pai ) 
	{
		if( pai.getValor() > num ) 
		{
			// Segue pela esquerda
			if( pai.getFilhoEsquerda().getHora() == null) 
			{
				
				NoBinTree novo = new NoBinTree(num);
				NoBinTree atual = pai.getFilhoEsquerda();
				atual.setFilhoEsquerda(novo);
			}
		}
		else if(  pai.getValor() < num ) 
			{
				// Segue pela direita
				if( pai.getFilhoDireita().getHora() == null) 
				{
					NoBinTree novo = new NoBinTree(num);
					NoBinTree atual = pai.getFilhoDireita();
					atual.setFilhoDireita(novo);
				}
			}
	}
	
	// -------------------------------------------- InserirCliente -------------------------------------
	public void inserirCliente(int numMesa)
	{
		NoBinTree no = procurar(numMesa);
		System.out.println(no);
		if(no!=null) 
		{
			if(no.getHora()==null) 
			{
				//System.out.println("N„o È null");
				LocalTime hora = LocalTime.now();
				
				no.setHora(hora);
				//System.out.println(no.getHora());
			}
			//System.out.println("… null");
		}
	}
	
	// -------------------------------------------- toString -------------------------------------------------
	@Override
	public String toString() {
		return "BinSearchTree [raiz=" + raiz + "]";
	}
}
