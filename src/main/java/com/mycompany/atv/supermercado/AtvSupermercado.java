/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.atv.supermercado;

import java.util.Scanner;

/**
 *
 * @author guilherme
 */
public class AtvSupermercado {

    public static void main(String[] args) {
        Scanner menu = new Scanner(System.in);

        produtos_supermercado[] listaProdutos = new produtos_supermercado[3];
        int opcao;

        do {
            System.out.println("\n---- MENU SUPERMERCADO ----");
            System.out.println("1 - Cadastrar produtos");
            System.out.println("2 - Editar produtos");
            System.out.println("3 - Visualizar produtos cadastrados");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = menu.nextInt();
            menu.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    // Cadastro
                    for (int i = 0; i < listaProdutos.length; i++) {
                        listaProdutos[i] = new produtos_supermercado();

                        System.out.println("\n--- Cadastro do Produto " + (i + 1) + " ---");
                        System.out.print("Nome: ");
                        listaProdutos[i].setNome(menu.nextLine());

                        System.out.print("Preço: ");
                        listaProdutos[i].setPreco(menu.nextDouble());
                        menu.nextLine();

                        System.out.print("Quantidade em estoque: ");
                        listaProdutos[i].setQtd_estoque(menu.nextInt());
                        menu.nextLine();

                        System.out.print("Código: ");
                        listaProdutos[i].setCodigo(menu.nextLine());
                    }
                    System.out.println("\nProdutos cadastrados com sucesso!");
                    break;

                case 2:
                    // Editar
                    System.out.print("\nDigite o número do produto que deseja editar (1 a 3): ");
                    int indice = menu.nextInt() - 1;
                    menu.nextLine();

                    if (indice < 0 || indice >= listaProdutos.length || listaProdutos[indice] == null) {
                        System.out.println("Produto não cadastrado!");
                        break;
                    }

                    System.out.println("\n---- Editar Produto " + (indice + 1) + " ----");
                    System.out.print("Novo nome: ");
                    listaProdutos[indice].setNome(menu.nextLine());

                    System.out.print("Novo preço: ");
                    listaProdutos[indice].setPreco(menu.nextDouble());
                    menu.nextLine();

                    System.out.print("Nova quantidade em estoque: ");
                    listaProdutos[indice].setQtd_estoque(menu.nextInt());
                    menu.nextLine();

                    System.out.print("Novo código: ");
                    listaProdutos[indice].setCodigo(menu.nextLine());

                    System.out.println("Produto atualizado com sucesso!");
                    break;

                case 3:
                    // Visualizar
                    System.out.println("\n---- Produtos Cadastrados ----");
                    for (int i = 0; i < listaProdutos.length; i++) {
                        if (listaProdutos[i] == null || listaProdutos[i].getNome() == null) {
                            System.out.println("[Não cadastrado]");
                        } else {
                            System.out.println("Nome: " + listaProdutos[i].getNome());
                            System.out.println("Preço: R$ " + listaProdutos[i].getPreco());
                            System.out.println("Quantidade: " + listaProdutos[i].getQtd_estoque());
                            System.out.println("Código: " + listaProdutos[i].getCodigo());
                        }
                    }
                    break;

                case 4:
                    System.out.println("Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }

        } while (opcao != 4);

        menu.close();
    }
}
