/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetoEDAListaEncadeadaOrdenada;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Leocaliban
 */
public class Principal {

    public static void menu() {
        System.out.println("1 - inserir no início");
        System.out.println("2 - inserir no final");
        System.out.println("3 - inserir em uma posição");
        System.out.println("4 - informar a posição de um elemento");
        System.out.println("5 - testar se um elemento existe");
        System.out.println("6 - informar o elemento de uma posição");
        System.out.println("7 - remover um elemento");
        System.out.println("8 - remover um elemento pela posição");
        System.out.println("9 - remover o elemento do início");
        System.out.println("10 - remover o elemento do final");
        System.out.println("11 - tamanho");
        System.out.println("12 - imprimir");
        System.out.println("0 - sair");
    }

    public static int lerInteiro(String mensagem, Scanner leitor) {
        System.out.print(mensagem);
        return Integer.parseInt(leitor.nextLine());
    }

    public static String lerString(String mensagem, Scanner leitor) {
        System.out.print(mensagem);
        return leitor.nextLine();
    }

    public static void exibirErro() {
        System.out.println("!!!!!!!!!");
        System.out.println("Operação não permitida.");
        System.out.println("!!!!!!!!!\n");
    }

    public static void exibirSucesso() {
        System.out.println("**********");
        System.out.println("Operação bem sucedida.");
        System.out.println("**********\n");
    }

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        int key;

        TListaProjeto lista = new ListaEncadeadaStringOrdenada();

        do {
            menu();
            key = lerInteiro("Opcao: ", leitor);

            switch (key) {
                case 1:
                //inserir no inicio	
                case 2:
                //inserir no fim
                case 3:
                    //inserir em uma posicao
                    String nome = lerString("Nome: ", leitor);
                    int posicao = 0;
                    boolean deuCerto = false;
                    if (key == 1) {
                        deuCerto = lista.inserir(nome);
                    } else if (key == 2) {
                        deuCerto = lista.inserir(nome);
                    } else {
                        posicao = lerInteiro("Posição: ", leitor);
                        deuCerto = lista.inserir(nome);
                    }
                    if (!deuCerto) {
                        exibirErro();
                    } else {
                        exibirSucesso();
                    }

                    break;
                case 4:
                case 5:
                    nome = lerString("Nome a ser pesquisado: ", leitor);
                    posicao = lista.posicao(nome);

                    if (posicao > 0) {
                        System.out.println("**********");
                        System.out.print("Existe ");

                        if (key == 4) {
                            System.out.print("na posição " + posicao+"\n");
                        }

                        System.out.println();

                    } else {
                        System.out.println("!!!!!!!!!");
                        System.out.println("Não existe");
                    }
                    break;

                case 6:
                    posicao = lerInteiro("Posição: ", leitor);
                    nome = lista.elemento(posicao);
                    if (nome == null) {
                        exibirErro();
                    } 
                    else {
                        System.out.println("-----------");
                        System.out.println(nome);
                        System.out.println("-----------\n");
                    }
                    break;
                case 7:
                    nome = lerString("Nome a ser removido: ", leitor);
                    deuCerto = lista.remover(nome);
                    if (deuCerto) {
                        exibirSucesso();
                    } else {
                        exibirErro();
                    }
                    break;
                case 8:
                    posicao = lerInteiro("Posição a ser removida: ", leitor);
                    nome = lista.elemento(posicao);
                    if (nome == null) {
                        exibirErro();
                    } else {
                        deuCerto = lista.remover(nome);
                        exibirSucesso();
                    }
                    break;
                case 9:
                case 10:
                    if (key == 9) {
                        posicao = 1;
                    } 
                    else//key == 10
                    {
                        posicao = lista.toArray().length;
                    }
                    nome = lista.elemento(posicao);

                    deuCerto = lista.remover(nome);

                    if (deuCerto) {
                        exibirSucesso();
                    } else {
                        exibirErro();
                    }
                    break;
                case 11:
                    System.out.println("**********");
                    System.out.println("Tamanho: " + lista.toArray().length);
                    System.out.println("**********\n");
                    break;
                case 12:
                    System.out.println("----------------");
                    System.out.println(Arrays.toString(lista.toArray()));
                    System.out.println("----------------\n");
                    break;
                default:
                    System.out.println("!!!!!!!!!");
                    System.out.println("Operação não suportada");
                    System.out.println("!!!!!!!!!\n");
                    break;
            }
        } while (key != 0);
    }
}
