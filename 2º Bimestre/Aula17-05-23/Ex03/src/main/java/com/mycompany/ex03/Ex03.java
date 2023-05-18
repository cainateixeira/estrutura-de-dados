package com.mycompany.ex03;

/**
 *
 * @author Cainã
 */
public class Ex03 {

    public static void main(String[] args) {
        try {
            int numero = 20; // Número desejado para a sequência Fibonacci

            System.out.println("Sequência Fibonacci de " + numero + ":");
            for (int i = 0; i <= numero; i++) {
                long resultado = calcularFibonacci(i);
                System.out.print(resultado + " ");
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro durante o cálculo da sequência Fibonacci.");
            e.printStackTrace();
        }
    }
    public static long calcularFibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return calcularFibonacci(n - 1) + calcularFibonacci(n - 2);
        }
    }
}
