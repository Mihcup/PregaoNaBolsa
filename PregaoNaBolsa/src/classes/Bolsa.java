package classes;

import classes.Fundos;
import classes.Investidor;

import java.util.ArrayList;
import java.util.List;

public class Bolsa {
    private List<Ativos> ativos;

    public Bolsa() {
        this.ativos = new ArrayList<>();
    }

    public void adicionarAtivo(Ativos ativo) {
        ativos.add(ativo);
    }

    public void processarOrdemCompra(Investidor investidor, String codigoAtivo, int quantidade, double precoMaximo) {
        for (Ativos ativo : ativos) {
            if (ativo.getCodigo().equals(codigoAtivo) && ativo.getPrecoAtual() <= precoMaximo) {
                if (ativo instanceof Acoes) {
                    Acoes acao = (Acoes) ativo;
                    if (acao.getQuantidade() >= quantidade) {
                        acao.setQuantidade(acao.getQuantidade() - quantidade);
                        investidor.addAtivonaCarteira(new Acoes(codigoAtivo, ativo.getPrecoAtual(), quantidade),"1254");
                        System.out.println(investidor.getNome() + " comprou " + quantidade + " ações de " + codigoAtivo);
                    } else {
                        System.out.println("Quantidade insuficiente de ações disponíveis para compra.");
                    }
                } else if (ativo instanceof Fundos) {
                    Fundos fundo = (Fundos) ativo;
                    double valorCompra = quantidade * ativo.getPrecoAtual();
                    if (fundo.getParticipacao() >= valorCompra) {
                        fundo.setParticipacao(fundo.getParticipacao() - valorCompra);
                        investidor.addAtivonaCarteira(new Fundos(codigoAtivo, ativo.getPrecoAtual(), valorCompra),"1234");
                        System.out.println(investidor.getNome() + " comprou " + quantidade + " cotas do fundo " + codigoAtivo);
                    } else {
                        System.out.println("Saldo insuficiente para comprar cotas do fundo.");
                    }
                }
            }
        }
    }



    @Override
    public String toString() {
        return "Bolsa: " +
                "Ativos: " + ativos +
                '}';
    }
}
