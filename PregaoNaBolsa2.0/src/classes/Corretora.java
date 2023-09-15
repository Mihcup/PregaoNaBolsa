package classes;

import classes.Investidor;

public class Corretora {
    private Bolsa bolsa;

    public Corretora(Bolsa bolsa) {
        this.bolsa = bolsa;
    }

    public void processarOrdemCompra(Investidor investidor, String codigoAtivo, int quantidade, double precoMaximo) {
        bolsa.processarOrdemCompra(investidor, codigoAtivo, quantidade, precoMaximo);
    }

    @Override
    public String toString() {
        return "Corretora: " +
                "Bolsa: " + bolsa.toString() +
                '\n';
    }
}
