public class Lista <E> implements ILista<E>{
	
	private Celula<NoBinTree> inicio;
	private int tamanho;



	public Lista() {
		inicio = null;
		tamanho = 0;
	}

	@Override
	public void insert(NoBinTree e) {

		Celula <NoBinTree> nova = new Celula<NoBinTree>(e);

		if(inicio == null) {
			inicio = nova;
		}else {
		sortedInsert(inicio,nova);

		}
		tamanho++;

	}
	public Celula<NoBinTree> sortedInsert(Celula<NoBinTree> inicio, Celula<NoBinTree> nova)
	{
		Celula<NoBinTree> current;
		// if list is empty
		if (inicio == null)
			inicio = nova;
			// if the node is to be inserted at the beginning
			// of the doubly linked list

		if (inicio.getElemento().getHora().isAfter(nova.getElemento().getHora()))
		{
			nova.setProximo(inicio);
			inicio.setAnterior(nova);
			inicio = nova;
		}
		else
		{
			current = inicio;
			// locate the node after which the new node
			// is to be inserted
			while (current.getProximo() != null &&
					current.getProximo().getElemento().getHora().isBefore(nova.getElemento().getHora()))
				current = current.getProximo();

			/* Make the appropriate links */
			nova.setProximo(current.getProximo()) ;

			// if the new node is not inserted
			// at the end of the list
			if (current.getProximo() != null)
				current.setAnterior(nova);

			current.setProximo(nova);
			nova.setAnterior(current);
		}
		return inicio;
	}


	@Override
	public String toString() {
		return "Lista{" +
				"inicio=" + inicio +
				", tamanho=" + tamanho +
				'}';
	}

	/*	@Override
        public void insertAfter(E prev, E e) {
            Celula <E> nova = new Celula<E>(e);

            if(inicio == null) {
                return;
            }

            Celula <E> celulaE = this.searchCelula(prev);

            if(celulaE == null) {
                return;
            }

            nova.setProximo(celulaE.getProximo());

            celulaE.setProximo(nova);

            nova.setAnterior(celulaE);

            if(nova.getProximo() != null) {
                nova.getProximo().setAnterior(nova);
            }

            tamanho++;

        }

        @Override
        public void insertBefore(E next, E e) {
            Celula <E> nova = new Celula<E>(e);

            if(inicio == null) {
                return;
            }

            Celula <E> celulaE = this.searchCelula(next);

            if(celulaE == null) {
                return;
            }

            nova.setAnterior(celulaE.getAnterior());

            celulaE.setAnterior(nova);

            nova.setProximo(celulaE);

            if (nova.getAnterior() != null) {
                nova.getAnterior().setProximo(nova);
            }else {
                inicio = nova;
            }

            tamanho++;

        }

        @Override
        public void delete(E e) {

            if(inicio == null) {
                return;
            }

            Celula <E> aRemover = this.searchCelula(e);

            if (aRemover == null)
            {
                return;
            }

            if (aRemover == inicio) {
                inicio = inicio.getProximo();
            }

            if(aRemover.getProximo() != null) {
                aRemover.getProximo().setAnterior(aRemover.getAnterior());
            }

            if(aRemover.getAnterior() != null) {
                aRemover.getAnterior().setProximo(aRemover.getProximo());
            }

            tamanho--;
        }

        public String printForward()
        {
            Celula <E> atual = inicio;

            String lista = "";

            while (atual.getProximo() != null) {

                lista += atual.getElemento() + "\n";

                atual = atual.getProximo();

            }

            lista += atual.getElemento() + "\n";

            return lista;
        }

        public String printBackward()
        {
            Celula <E> atual = this.getLast();

            if(atual == null) {
                return "";
            }

            String lista = "";

            while (atual.getAnterior() != null) {

                lista += atual.getElemento() + "\n";

                atual = atual.getAnterior();

            }

            lista += atual.getElemento() + "\n";

            return lista;
        }

        private Celula <E> searchCelula(E e)
        {
            if(inicio == null) {
                return null;
            }

            Celula <E> atual = inicio;

            while (atual.getProximo() != null && e != atual.getElemento()) {

                atual = atual.getProximo();

            }

            return e != atual.getElemento() ? null : atual;
        }

        private Celula <E> getLast()
        {
            if(inicio == null) {
                return null;
            }

            Celula <E> atual = inicio;

            while (atual.getProximo() != null) {

                atual = atual.getProximo();

            }

            return atual;
        }*/
	public Boolean estaVazia(){
		if(inicio==null){
			return true;
		}
		return false;
	}
}
