package ProjetoEDAListaEncadeadaOrdenada;

public class ListaEncadeadaStringOrdenada implements TListaProjeto {

    //lista que vai ser percorrida
    private No lista;
    //array onde os nós serao inserideos pelo toArray
    private String[]array;
    //quantidade de elementos
    private int quantidade = 0;

    //inicializar com a lista vazia no construtor
    public ListaEncadeadaStringOrdenada() {
        this.lista = null;
    }

    @Override
    //inserir um elemento string na lista
    //como a lista é ordenada então não precisa de posição
    //sempre que for inserido um elemento ele irá para sua posição correta
    public boolean inserir(String s) {
        //cria o nó novo, parametro de entrada é a string e a lista atual
        No novo = new No(s, lista);
        //esse if é para inserir de forma ordenada no inicio
        //se a lista for nula ou o dado que estiver na lista for maior ou igual ao novo dado
        if (lista == null || lista.dado.compareTo(s) >= 0) {
            //novo vai apontar para a lista
            novo.proximo = lista;
            //lista vai ser o novo
            lista = novo;
            this.quantidade++;
            return true;
        } 
        else {
            //se a lista não for vazia ou, se o primeiro elemento for maior que o novo então
            //tem que percorer a lista procurando um lugar para o novo item se encaixar de forma ordenada
            //cria o Nó auxiliar sempre que for pecorrer a lista para não perder o valor da lista verdadeira
            No aux = lista;
            //enquanto aux.proximo for diferente de null e o novo (string que vai ser inserida)
            //for maior que o aux.proximo.dado 
            while (aux.proximo != null && s.compareTo(aux.proximo.dado) >= 0) {
                //aux avança para o proximo
                aux = aux.proximo;
            }
            //agora, o novo.prox aponta para aux.prox e o aux.prox é um novo
            novo.proximo = aux.proximo;
            aux.proximo = novo;
            this.quantidade++;
            return true;
        }
    }

    @Override
    //remover um elemento da lista ordenada
    //aqui vamos usar um no que guarda a posição ant para sempre que o seu proximo ser removido o ant aponta para 
    //o aux.prox.
    public boolean remover(String s) {
        //verifica a lista vazia
        if (lista == null) {
            return false;
        } 
        //verifica se o dado é o primeiro da lista
        else if (lista.dado.contains(s)) {
            lista = lista.proximo;
            this.quantidade--;
            return true;
        } 
        //se nao, agora vamos percorrer a lista
        else {
            No aux = lista;
            No ant = null;
            //enquando aux.prox for diferente de null
            while (aux.proximo != null) {
                //verifica se aux contem o dado, se tiver o dado ai paramos o while
                if (aux.dado.contains(s)) {
                    break;
                } 
                //se não contem então guardamos o valor de aux em ant, e andamos com o aux para o proximo no
                else {
                    ant = aux;
                    aux = aux.proximo;
                }
            }
            //lixo é o nó que será excluido
            No lixo = aux;
            //esse if serve para verificar o ultimo aux do while, já que no while ele para quando o prox for null então o
            //dado desse aux não vai ser verificado no while então verifica aqui
            //se ant.prox.dado não for igual ao dado é porque o dado ou elemento nao existe na lista
            if (!ant.proximo.dado.contains(s)) {
                return false;
            } 
            //se ant.proximo.dado for igual ao dado que vai ser removido
            else if (ant.proximo.dado.contains(s)) {
                //ant.prox aponta para lixo.prox
                ant.proximo = lixo.proximo;
                //aux.prox aponta pra null
                aux.proximo = null;
            }
            //retira valor da lista e item removido
            this.quantidade--;
            return true;
        }
    }

    @Override
    //saber a posição do elemento
    //vamos criar um contador e o aux para percorrer a lista
    public int posicao(String s) {
        int cont = 0;
        No aux = lista;
        //se o primeiro item for igual ao elemento ja para por aqui e retorna a posicao
        if (lista.dado.contains(s)) {
            cont++;
            return cont;
        } 
        //se nao
        else {
            //enquanto aux.prox nao for null e o elemento buscado for maior ou igual ao elemento de aux. prox
            while (aux.proximo != null && s.compareTo(aux.proximo.dado) >= 0) {
                //avança a lista e conta mais um no contador de posicao
                aux = aux.proximo;
                cont++;
            }
            //aqui vamos verificar se o while chegou no final da lista
            //se aux.dado nao for igual ao dado e o contador +1 for igual a quantidade de itens na lista
            //então o contador será zero porque nao existe o elemento na lista
            //o +1 vem do ultimo elemento que o while não percorre deixando de contar o +1 nele
            if (!aux.dado.contains(s) && cont+1 == this.quantidade) {
                cont = 0;
            }
            //se aux.dado for igual ao elemento procurado então contador adiciona mais um porque esse
            //foi o ultimo elemento da lista onde o while nao contabilizou
            else if(aux.dado.contains(s)){
                cont++;
            }
        }
        return cont;
    }

    @Override
    //recuperar o elemento atravez da posicao
    public String elemento(int pos) {
        //inicializa o aux
        No aux = null;
        //verifica se a posicao é maior do que a quantidade de elementos que a lista possui ou menos que zero
        if(pos>quantidade || pos<0){
            return null;
        }
        else{
            aux = lista;
            //percorre com um for até a posição indicada 
            for (int i = 1; i < pos; i++) {
                aux = aux.proximo;
            }
            // retorna o dado da posicao
            return aux.dado;
        }          
    }

    @Override
    //coloca todos os nós em um array
    public String[] toArray() {
        //cria o array com o tamanho quantidade de nos
        array = new String[this.quantidade];
        //cria o aux paara percorrer
        No aux = lista;
        //verifica se está vazia
        if(this.quantidade==0){
            System.out.println("LISTA VAZIA");
        }
        //se nao, percorre a lista 
        else{
            //usando um for, para percorrer ate o a quantidade de elementos
            //adiciona ao array na posicao i o aux.dado e percorre mais um com aux.prox
            for(int i = 0;i<this.quantidade;i++){
                array[i] = aux.dado;
                aux = aux.proximo;
            }
        }
        return array;
        
    }

    public No getLista() {
        return lista;
    }
}
    

