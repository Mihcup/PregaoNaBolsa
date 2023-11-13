package sorting;
import bolsa.Investidor;
import implementacoes.Lista;

public class ShellSort {
    public static void sortShell(int[] arr) {
        int n = arr.length;
        int gap = n / 2;
        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
            gap /= 2;
        }
    }
    public static void sortInvestidoresPorNome(Lista<Investidor> investidores) {
        int n = investidores.getSize();
        int gap = n / 2;
        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                Investidor temp = investidores.retornarValor(i);
                int j = i;
                while (j >= gap && investidores.retornarValor(j-gap).getNome().compareTo(temp.getNome()) > 0) {
                    investidores.substituirValor(j,investidores.retornarValor(j-gap));
                    j -= gap;
                }
                investidores.substituirValor(j,temp);
            }
            gap /= 2;
        }
    }
}

