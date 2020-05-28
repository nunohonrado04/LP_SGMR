import java.time.LocalDateTime;
import java.util.Queue;

public class BinSearchTree implements BinTree {

	private NoBinTree raiz;

	// M�todos da Interface BinTree
	@Override
	public void inserir(int num) {

		raiz = inserir(raiz, num);

	}

	private NoBinTree inserir(NoBinTree no, int num) {
		if (no == null) {
			return new NoBinTree(num);
		}

		if (num < no.getNrMesa()) {
			no.setFilhoEsquerda(inserir(no.getFilhoEsquerda(), num));
		} else if (num > no.getNrMesa()) {
			no.setFilhoDireita(inserir(no.getFilhoDireita(), num));
		}

		return no;
	}

	@Override
	public NoBinTree procurar(int num) {
		
		return procurar(raiz, num);
	}
	private NoBinTree procurar(NoBinTree no, int num)
	{
		if(no == null) {
			return null;
		}

		if(num < no.getNrMesa()) {

			return procurar(no.getFilhoEsquerda(), num);

		}else if(num > no.getNrMesa()) {

			return procurar(no.getFilhoDireita(), num);

		} else {

			return no;
		}
	}


	public ListaFila preOrdem() {
		if (raiz == null) {
			return "arvore vazia";
		}
		return preOrdem(raiz);
	}

	public Lista preOrdem(NoBinTree no) {
		Lista listaOrdemChegada= new Lista();

		if(no != null) {
			if(listaOrdemChegada.estaVazia()){
				listaOrdemChegada.insert(no);
			}

			retorno += no.getNrMesa() + " ";
		}
		
		if(no.getFilhoEsquerda() != null) {
			retorno += preOrdem(no.getFilhoEsquerda());
		}
		
		if(no.getFilhoDireita() != null) {
			retorno += preOrdem(no.getFilhoDireita());
		}

		if(listaOrdemChegada.estaVazia()){

		}
		return retorno;
	}

	public String inOrdem() {
		if (raiz == null) {
			return "arvore vazia";
		}

		return inOrdem(raiz);
	}

	public String inOrdem(NoBinTree no) {
		String retorno = "";
		
		if(no.getFilhoEsquerda() != null) {
			retorno += inOrdem(no.getFilhoEsquerda());
		}
		
		retorno += no.getNrMesa() + " ";
		
		if(no.getFilhoDireita() != null) {
			retorno += inOrdem(no.getFilhoDireita());
		}
		
		return retorno;
	}

	public String posOrdem() {
		if (raiz == null) {
			return "arvore vazia";
		}

		return posOrdem(raiz);
	}

	public String posOrdem(NoBinTree no) {
		String retorno = "";
		
		if(no.getFilhoEsquerda() != null) {
			retorno += posOrdem(no.getFilhoEsquerda());
		}
		
		if(no.getFilhoDireita() != null) {
			retorno += posOrdem(no.getFilhoDireita());
		}
		
		retorno += no.getNrMesa() + " ";
		
		return retorno;
	}

	@Override
	public String toString() {
		return "BinSearchTree [raiz=" + raiz + "]";
	}


	


}
