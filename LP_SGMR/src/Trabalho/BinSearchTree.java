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
	}//inserirMesa
	
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
				throw new IllegalArgumentException("não são permitidos valores duplicados !");	
			}		
	}//inserir
	
	// -------------------------------------------- EliminarMesa -------------------------------------------------
	public void EliminarMesa(int num)
	{
		raiz = eliminar(raiz, num);
	}
	
	private NoBinTree eliminar(NoBinTree no, int num)
	{
		if(no == null) 
		{
			return no;
		}
		
		if(num < no.getValor()) 
		{
			no.setFilhoEsquerda(eliminar(no.getFilhoEsquerda(), num));
		} else if(num > no.getValor()) 
		{
			no.setFilhoDireita(eliminar(no.getFilhoDireita(), num));
		}
		else 
		{	
			if(no.getFilhoEsquerda() == null) 
			{
				return no.getFilhoDireita();
			}
			else if(no.getFilhoDireita() == null) 
			{
				return no.getFilhoEsquerda();
			}

			no.setValor(min(no.getFilhoDireita()));
			no.setFilhoDireita(eliminar(no.getFilhoDireita(), no.getValor()));
		}

		return no;
	}//EliminarMesa
	
	public int min()
	{
		return min(raiz);
	}//min
	
	private int min(NoBinTree no)
	{
		if(no.getFilhoEsquerda() == null) 
		{
			return no.getValor();
		}
		
		return min(no.getFilhoEsquerda());
	}//min
	// -------------------------------------------- Procurar -------------------------------------------------
	public NoBinTree procurar( int num ) 
	{
		if( raiz == null ) 
		{
			return null;
		}
		else
			return procurar(num, raiz);
	}//procurar
	
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
	
	}//procurar
	
	// -------------------------------------------- PreOrder -------------------------------------------------
	private void visita( NoBinTree no, LinkedList<NoBinTree> nosVisitados, Lista ordemChegada )
	{
		
		if(no.getHora()!=null) 
		{
			ordemChegada.push(no);
		}
		nosVisitados.add(no);
	}//visita

	public Lista preOrder() 
	{
		LinkedList<NoBinTree> nosVisitados = new LinkedList<NoBinTree>();
		Lista ordemChegada = new Lista();
		
		preOrder(raiz, nosVisitados,ordemChegada);
	
		return ordemChegada;
	}//preOrder
	
	private void preOrder( NoBinTree no, LinkedList<NoBinTree> nosVisitados, Lista ordemChegada )
	{
		if( no == null)
			return;
		
		visita(no, nosVisitados, ordemChegada);
		preOrder( no.getFilhoEsquerda(), nosVisitados, ordemChegada );
		preOrder( no.getFilhoDireita(), nosVisitados, ordemChegada );
		
	}//preOrder
	
	// -------------------------------------------- PreOrderOcupacao -------------------------------------------------
	private void visitaOcupacao( NoBinTree no, LinkedList<NoBinTree> nosVisitados, Lista mesasPermitidoSentar ) 
	{
		if(!no.isOcupada())
		{
			mesasPermitidoSentar.push(no);
			no.setOcupada(true);
			if(no.getFilhoEsquerda()!=null) 
			{
				no.getFilhoEsquerda().setOcupada(true);
			}
			if(no.getFilhoDireita()!=null) 
			{
				no.getFilhoDireita().setOcupada(true);
			}
		}
		
		nosVisitados.add(no);
	}//visitaOcupacao
		
		
	public Lista preOrderOcupacao() 
	{
		LinkedList<NoBinTree> nosVisitados = new LinkedList<NoBinTree>();
		Lista mesasPermitidoSentar = new Lista();
			
		preOrderOcupacao(raiz, nosVisitados, mesasPermitidoSentar);
			
		return mesasPermitidoSentar;
	}//preOrderOcupacao
		
	private void preOrderOcupacao( NoBinTree no, LinkedList<NoBinTree> nosVisitados, Lista mesasPermitidoSentar )
	{
		if( no == null)
			return;
			
		visitaOcupacao(no, nosVisitados, mesasPermitidoSentar);
		preOrderOcupacao( no.getFilhoEsquerda(), nosVisitados, mesasPermitidoSentar );
		preOrderOcupacao( no.getFilhoDireita(), nosVisitados, mesasPermitidoSentar );
			
	}//preOrderOcupacao
	// -------------------------------------------- ImprimirProximaMesa -------------------------------------
	public int imprimirProximaMesa(Pilha listaPilhaMesasDistancia)
	{
		return listaPilhaMesasDistancia.obter();
	}//imprimirProximaMesa
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
	}//inserirCliente
	
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
	}//marcarMesa
		
	// -------------------------------------------- DesenharArvore -------------------------------------------------
  
	public void desenharArvore() 
	{
		imprimir(raiz);
	}//desenharArvore
		
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
	}//imprimirArvore
		  
		 
	private static void imprimir(NoBinTree raiz)  
	{    
		imprimirArvore(raiz, 0);  
	}//imprimir
		  
}//BinSearchTree
