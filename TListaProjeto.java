package ProjetoEDAListaEncadeadaOrdenada;

public interface TListaProjeto {
    
    /**
	 * insere o elemento na lista na posição passada como parâmetro
	 * @param s elemento a ser inserido
	 * @return true se a inserção foi realizada com sucesso e falso caso contrário
	 */
	public boolean inserir(String s);

	/**
	 * remove o elemento s da lista
	 * @param s elemento que será removido da lista
	 * @return true se a remoção foi realizada com sucesso e false caso contrário
	 */
	public boolean remover(String s);
	
	/**
	 * informa em que posição da lista o elemento encontrando como parâmetro está
	 * @param s elemento que se deseja saber a posição
	 * @return 0 se o elemento não estiver na lista ou a lista estiver vazia, qualquer valor positivo se o elemento estiver na lista (posicao > 0)
	 */
	public int posicao(String s);
	
	/**
	 * informa qual o elemento da posição passada por parâmetro
	 * @param pos posição cujo elemento se deseja recuperar
	 * @return o elemento daquela posição, null caso a posiçao seja inválida
	 */
	public String elemento(int pos);

	/**
	 * 
	 * @return retorna um cópia da lista no formato de array
	 */
	public String[] toArray();
    
}
