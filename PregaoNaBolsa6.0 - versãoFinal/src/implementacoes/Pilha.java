package implementacoes;

public class Pilha {
    private int[] pilha;
    private int tamanhoMaximo;
    private int topo;

    public Pilha(int tamanhoMaximo) {
        this.pilha = new int[tamanhoMaximo];
        this.tamanhoMaximo = tamanhoMaximo;
        this.topo = -1;
    }

    public void empilha(int elemento) {
        if (cheia()) {
            System.out.println("A pilha está cheia");
        } else {
            topo++;
            pilha[++topo] = elemento;
        }
    }

    public int desimpilha() {
        if (vazia()) {
            System.out.println("A pilha está vazia");
            return -1;
        } else {
            int elemento = pilha[topo];
            topo--;
            return elemento;
        }
    }

    public int topo(){
        if(vazia()){
            System.out.println("A pilha está vazia");
            return -1;
        }else{
            return pilha[topo];
        }
    }

    public boolean vazia(){
        return topo == -1;
    }

    public boolean cheia(){
        return topo == tamanhoMaximo-1;
    }

    public int tamanho(){
        return topo+1;
    }

    public void percorrerPilha() {
        if (vazia()) {
            System.out.println("A pilha está vazia");
            return;
        }

        for (int i = topo; i >= 0; i--) {
            System.out.print(pilha[i] + " ");
        }
        System.out.println();
    }
}

