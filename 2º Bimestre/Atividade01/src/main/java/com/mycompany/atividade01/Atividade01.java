package com.mycompany.atividade01;

import javax.swing.JOptionPane;

/**
 *
 * @author caina.teixeira
 */
public class Atividade01 {

    public static void main(String[] args) {
        int quantidade = Integer.parseInt(JOptionPane.showInputDialog(
                "Informe a quantidade de números a cadastrar:"));

        int[] numeros = new int[quantidade];

        JOptionPane.showMessageDialog(null, 
                "Digite os números (um por linha):");
        for (int i = 0; i < quantidade; i++) {
            numeros[i] = Integer.parseInt(JOptionPane.showInputDialog(
                    "Número " + (i + 1) + ":"));
        }

        bubbleSort(numeros);

        String[] opcoes = {"Pesquisa Linear", "Pesquisa Binária"};
        int opcao = JOptionPane.showOptionDialog(null,
                "Selecione o tipo de pesquisa:", "Opção de Pesquisa",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

        int numeroPesquisado = Integer.parseInt(JOptionPane.showInputDialog(
                "Informe o número a ser pesquisado:"));

        int resultado;

        if (opcao == 0) {
            resultado = pesquisaLinear(numeros, numeroPesquisado);
        } else if (opcao == 1) {
            resultado = pesquisaBinaria(numeros, numeroPesquisado);
        } else {
            JOptionPane.showMessageDialog(null, "Opção inválida!");
            return;
        }

        if (resultado == -1) {
            JOptionPane.showMessageDialog(null, 
                    "O número não foi encontrado na lista.");
        } else {
            JOptionPane.showMessageDialog(null,
                    "O número foi encontrado na posição: " + resultado);
        }
    }

    public static int pesquisaLinear(int[] lista, int numero) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == numero) {
                return i;
            }
        }
        return -1;
    }

    public static int pesquisaBinaria(int[] lista, int numero) {
        int inicio = 0;
        int fim = lista.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;

            if (lista[meio] == numero) {
                return meio;
            }

            if (numero < lista[meio]) {
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }

        return -1;
    }

    public static void bubbleSort(int[] lista) {
        int n = lista.length;
        boolean trocado;

        for (int i = 0; i < n - 1; i++) {
            trocado = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (lista[j] > lista[j + 1]) {
                    int temp = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = temp;
                    trocado = true;
                }
            }

            if (!trocado) {
                break;
            }
        }
    }
}
