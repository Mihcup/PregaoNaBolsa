package bolsa;

import implementacoes.Arvore;
import implementacoes.Lista;

public class Corretora {
    private String nome;
    private Bolsa bolsa;

    public Corretora(String nome, Bolsa bolsa) {
        this.nome = nome;
        this.bolsa = bolsa;
    }


    @Override
    public String toString() {
        return "Corretora: " +
                "\n Nome: " + nome+
                " Bolsa: " + bolsa.toString();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Bolsa getBolsa() {
        return bolsa;
    }

    public void setBolsa(Bolsa bolsa) {
        this.bolsa = bolsa;
    }

    public void processarOrdemCompra(Investidor investidor, Ativos ativo, int quantidade) {
        bolsa.processarOrdemCompra(investidor, ativo,quantidade);
    }
    public void processarOrdemVenda(Investidor investidor, Ativos ativo) {
        bolsa.processarOrdemVenda(investidor, ativo);
    }
}


