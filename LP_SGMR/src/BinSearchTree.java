import java.time.LocalDateTime;

public class BinSearchTree implements BinTree {

	private NoBinTree raiz;

	@Override
	public void atribuirMesa(int valor) {
		if (procurar(valor) == null) {
			throw new IllegalArgumentException("não existe a mesa!");
		}
		procurar(valor).setHora(LocalDateTime.now());
	}

	// M�todos da Interface BinTree
	@Override
	public void inserir(int num) {

		raiz=inserirV(raiz,num);
	}
	private  NoBinTree inserirV(NoBinTree raiz,int num) {
		if (raiz == null) {
			raiz = new NoBinTree(num);
			return raiz;
		}
		if(raiz.getNrMesa()==num){
			throw new IllegalArgumentException("ja existe");
		}
		if (num < raiz.getNrMesa()) {
			raiz.setFilhoEsquerda(inserirV(raiz.getFilhoEsquerda(),num));
		} else if (num > raiz.getNrMesa()) {
			raiz.setFilhoDireita(inserirV(raiz.getFilhoDireita(), num));
		}
		return raiz;
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


	public Lista preOrdem() {
		if (raiz == null) {
			return null;
		}
		return preOrdem(raiz);
	}

	public Lista preOrdem(NoBinTree no) {
		Lista listaOrdemChegada= new Lista();
		String retorno="";
		if(no != null) {
			if(listaOrdemChegada.estaVazia()){
				listaOrdemChegada.insert(no);
			}

		 retorno += no.getHora() + " ";
		}

		if(no.getFilhoEsquerda() != null) {
			retorno += preOrdem(no.getFilhoEsquerda());
		}

		if(no.getFilhoDireita() != null) {
			retorno += preOrdem(no.getFilhoDireita());
		}

		if(listaOrdemChegada.estaVazia()){
			throw new IllegalArgumentException("Não existe mesas ocupadas");
		}
		return listaOrdemChegada;
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
		
		retorno += no.getHora() + " ";
		
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
		
		retorno += no.getHora() + " ";
		
		return retorno;
	}

	@Override
	public String toString() {
		return "BinSearchTree [raiz=" + raiz + "]";
	}


	


}
