package Trabalho;

import java.time.LocalTime;
import java.util.LinkedList;
import java.util.Queue;


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
				// num é igual a pai.getValor(), 
				// não são permitidos duplicados
			
				throw new IllegalArgumentException("não são permitidos valores duplicados !");	
			}		
	}
	
	// -------------------------------------------- EliminarMesa -------------------------------------------------
	public void EliminarMesa(int num)
	{
		raiz = eliminar(raiz, num);
	}
	
	private NoBinTree eliminar(NoBinTree no, int num)
	{
		if(no == null) {
			return no;
		}
		
		if(num < no.getValor()) {
			no.setFilhoEsquerda(eliminar(no.getFilhoEsquerda(), num));
		} else if(num > no.getValor()) {
			no.setFilhoDireita(eliminar(no.getFilhoDireita(), num));
		}else {
			
			if(no.getFilhoEsquerda() == null) {
				return no.getFilhoDireita();
			}else if(no.getFilhoDireita() == null) {
				return no.getFilhoEsquerda();
			}

			no.setValor(min(no.getFilhoDireita()));
			no.setFilhoDireita(eliminar(no.getFilhoDireita(), no.getValor()));
		}

		return no;
	}
	
	public int min()
	{
		return min(raiz);
	}
	
	private int min(NoBinTree no)
	{
		if(no.getFilhoEsquerda() == null) 
		{
			return no.getValor();
		}
		
		return min(no.getFilhoEsquerda());
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
		
		if(no.getHora()!=null) {
			ordemChegada.push(no);
		}
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
	public void inserirComDistanciaEntreMesas()
	{
		if( raiz.getHora() == null ) 
		{
			LocalTime hora = LocalTime.now();
			raiz.setHora(hora);
		}
		else
		{
			if(raiz.getFilhoEsquerda().getHora()==null && raiz.getFilhoEsquerda().getFilhoEsquerda().getHora()==null || raiz.getFilhoDireita().getFilhoDireita().getHora()==null)
			{
				raiz = raiz.getFilhoEsquerda();
			}
			else if(raiz.getFilhoDireita().getHora()==null && raiz.getFilhoEsquerda().getFilhoEsquerda().getHora()==null || raiz.getFilhoDireita().getFilhoDireita().getHora()==null)
			{
				raiz = raiz.getFilhoDireita();
			}
			else {
				throw new IllegalArgumentException("Distância não cumprida!");
			}
			
			inserirComDistanciaEntreMesas(raiz);
		}
	}
	
	private void inserirComDistanciaEntreMesas(NoBinTree pai ) 
	{
		if(pai.getFilhoEsquerda().getHora()==null)
		{
			LocalTime hora = LocalTime.now();
			pai.getFilhoEsquerda().setHora(hora);
		}else if(pai.getFilhoDireita().getHora()==null)
		{
			LocalTime hora = LocalTime.now();
			pai.getFilhoDireita().setHora(hora);
		}
	}
	
	// -------------------------------------------- PreOrderOcupacao -------------------------------------------------
		private void visitaOcupacao( NoBinTree no, LinkedList<NoBinTree> nosVisitados )
		{
			nosVisitados.add(no);
		}

		public void preOrderOcupacao() 
		{
			LinkedList<NoBinTree> nosVisitados = new LinkedList<NoBinTree>();
			
			preOrderOcupacao(raiz, nosVisitados);
			
		}
		
		private void preOrderOcupacao( NoBinTree no, LinkedList<NoBinTree> nosVisitados )
		{
			if( no == null)
				return;
			
			visitaOcupacao(no, nosVisitados);
			preOrderOcupacao( no.getFilhoEsquerda(), nosVisitados);
			preOrderOcupacao( no.getFilhoDireita(), nosVisitados);
			
		}
	// -------------------------------------------- InserirCliente -------------------------------------
	public void inserirCliente(int numMesa)
	{
		NoBinTree no = procurar(numMesa);
		if(no!=null) 
		{
			if(no.getHora()==null) 
			{
				LocalTime hora = LocalTime.now();
				
				no.setHora(hora);
			}
		}
	}
	
	// -------------------------------------------- MarcarMesa -------------------------------------
		public void marcarMesa(int numMesa)
		{
			if(procurar(numMesa)!=null) {
				NoBinTree no = procurar(numMesa);
				if(no.getHora()==null) {
					if(!no.isMarcada()) {
						no.setMarcada(true);
					}
					else
					{
						throw new IllegalArgumentException("Esta mesa já se encontra marcada.");
					}
				}
			}
		}
		
	// -------------------------------------------- DesenharArvore -------------------------------------------------
  
		public void desenharArvore() 
		{
			imprimir(raiz);
		}
		
		private static void imprimirArvore(NoBinTree raiz, int space)  
		{  
			int COUNT = 10;
		      
		    if (raiz == null)  
		        return;  
		  
		    space += COUNT;  
		  
		    
		    imprimirArvore(raiz.getFilhoDireita(), space);  
		   
		    System.out.print("\n");  
		    for (int i = COUNT; i < space; i++)  
		        System.out.print(" ");  
		    System.out.print("["+raiz.getValor() + "]\n");  
		    
		    imprimirArvore(raiz.getFilhoEsquerda(), space);  
		}  
		  
		 
		private static void imprimir(NoBinTree raiz)  
		{    
		    imprimirArvore(raiz, 0);  
		}  
		  
	
}
