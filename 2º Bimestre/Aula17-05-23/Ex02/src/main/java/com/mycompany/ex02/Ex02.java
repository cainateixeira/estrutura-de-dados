package com.mycompany.ex02;

import java.util.Scanner;

/**
 *
 * @author Cainã
 */
public class Ex02 {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Informe um número inteiro: ");

        try {
            int numero = scanner.nextInt();
            long fatorial = calcularFatorial(numero);
            System.out.println("O fatorial de " + numero + " é: " + fatorial);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro durante o cálculo do fatorial.");
            e.printStackTrace();
        }
    }
    
    public static long calcularFatorial(int numero) {
        if (numero == 0) {
            return 1;
        } else {
            return numero * calcularFatorial(numero - 1);
        }
    }
}
