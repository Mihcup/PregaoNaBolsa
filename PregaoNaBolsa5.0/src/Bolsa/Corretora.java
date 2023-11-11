package Bolsa;

import Implementacoes.Arvore;

public class Corretora {
    private Bolsa bolsa;
    private Arvore investidores;

    public Corretora(Bolsa bolsa) {
        this.bolsa = bolsa;
    }



    @Override
    public String toString() {
        return "Corretora: " +
                "Bolsa: " + bolsa.toString() +
                "\nÁrvore de investidores: "+ investidores.toString() +
                '\n';
    }

    public Arvore getInvestidores() {
        return investidores;
    }

    public void setInvestidores(Arvore investidores) {
        this.investidores = investidores;
    }

    public int getSizeInvestidores(){
        return investidores.getSize();
    }
}

