package com.mycompany.ex01;

/**
 *
 * @author Cainã
 */
public class Ex01 {

    public static void main(String[] args) {
        
        int resultado = somaZeroAte50(0);
        System.out.println("A soma de 0 a 50 é: " + resultado);
    }
    
    public static int somaZeroAte50(int n) {
        try {
            if (n <= 50) {
                return n + somaZeroAte50(n + 1);
            } else {
                return 0;
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro durante a soma.");
            e.printStackTrace();
            return 0;
        }
    }
}
