import java.time.LocalDateTime;

/**
 * Interface BinTree
 * Representacao em Java do Tipo de Dados Abstracto Arvore Binaria
 * 
 * 
 */
public interface BinTree {
	
	/**
	 * Insere um numero na arvore
	 * 
	 * @param num  n�mero a inserir
	 * @throws IllegalArgumentException  se j� existir o 'num' na �rvore
	 */
	public void inserir(int num);

	/**
	 * Procura um determinado numero na arvore
	 * 
	 * @param num
	 * @return retorna uma refer�ncia para o n� que armazena o valor 'num' se existir
	 *                 ou null se o 'num' n�o existir na �rvore
	 */
	public NoBinTree procurar( int num );
	

}
