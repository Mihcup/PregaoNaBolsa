package classes;

import ImplementacaoLista.Lista;
import classes.*;

public class Bolsa {
    private String nome;
    private Lista<Ativos> ativos;

    public Bolsa(String nome) {
        this.nome = nome;
        this.ativos = new Lista();
    }

    public void adicionarAtivo(Ativos ativo) {
        ativos.add(ativo);
    }


    public void processarOrdemCompra(Investidor investidor, String codigoAtivo, int quantidade, double precoMaximo) {
        for (int i =0; i<ativos.getSize(); i++) {
            Ativos ativo = ativos.retornarValor(i);
            if (ativo.getCodigo().equals(codigoAtivo) && ativo.getPrecoAtual() <= precoMaximo) {
                if (ativo instanceof Acoes) {
                    Acoes acao = (Acoes) ativo;
                    if (acao.getQuantidade() >= quantidade) {
                        acao.setQuantidade(acao.getQuantidade() - quantidade);
                        investidor.addAtivonaCarteira(new Acoes(codigoAtivo, ativo.getPrecoAtual(), ativo.getEmpresa(), quantidade),"1254");
                        System.out.println(investidor.getNome() + " comprou " + quantidade + " ações de " + codigoAtivo);
                    } else {
                        System.out.println("Quantidade insuficiente de ações disponíveis para compra.");
                    }
                } else if (ativo instanceof Fundos) {
                    Fundos fundo = (Fundos) ativo;
                    double valorCompra = quantidade * ativo.getPrecoAtual();
                    if (fundo.getParticipacao() >= valorCompra) {
                        fundo.setParticipacao(fundo.getParticipacao() - valorCompra);
                        investidor.addAtivonaCarteira(new Fundos(codigoAtivo, ativo.getPrecoAtual(),ativo.getEmpresa(), valorCompra),"1234");
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
        String exibir;
        exibir = "Bolsa: " + "Nome: "+nome+ ", Ativos: ";
        for (int i = 0; i < ativos.getSize(); i++) {
            Ativos a = ativos.retornarValor(i);
            exibir+= a.toString();
        }

        return exibir;
    }
}
