package Sorting;

import Bolsa.Acoes;

public class BubbleSort {
    public static void sortBubble(int[] arr) {
        int n = arr.length;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int x = 1; x < (n - i); x++) {
                if (arr[x - 1] > arr[x]) {
                    temp = arr[x - 1];
                    arr[x - 1] = arr[x];
                    arr[x] = temp;
                }
            }
        }
    }

    public static void sortTop10AcoesMaisVendidas(Acoes[] acoes) {
        int n = acoes.length;

        // Usando o Bubble Sort para ordenar as ações com base na quantidade
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (acoes[j].getQuantidade() < acoes[j + 1].getQuantidade()) {
                    // Trocar ações de posição
                    Acoes temp = acoes[j];
                    acoes[j] = acoes[j + 1];
                    acoes[j + 1] = temp;
                }
            }
        }

        // Exibir as 10 ações mais vendidas
        System.out.println("Top 10 Ações Mais Vendidas:");
        for (int i = 0; i < Math.min(10, n); i++) {
            System.out.println(acoes[i]);
        }
    }

}
