package Bolsa;

import Implementacoes.Lista;

public class Bolsa {
    private String nome;
    private Lista<Ativos> ativos;

    public Bolsa(String nome) {
        this.nome = nome;
        this.ativos = new Lista();
    }

    public void processarOrdem(Investidor investidor, String codigoAtivo, int quantidade, double preco, boolean compra) {
        for (int i = 0; i < ativos.getSize(); i++) {
            Ativos ativo = ativos.retornarValor(i);
            if (ativo.getCodigo().equals(codigoAtivo) && ((compra && ativo.getPrecoAtual() <= preco) || (!compra && ativo.getPrecoAtual() >= preco))) {
                if (ativo instanceof Acoes) {
                    //compra de um ativo
                    Acoes acao = (Acoes) ativo;
                    if (compra) {
                        if (acao.getQuantidade() >= quantidade) {
                            acao.setQuantidade(acao.getQuantidade() - quantidade);
                            investidor.addAtivonaCarteira(new Acoes(codigoAtivo, ativo.getPrecoAtual(), ativo.getEmpresa(), quantidade), "1254");
                            System.out.println(investidor.getNome() + " comprou " + quantidade + " ações de " + codigoAtivo);
                        } else {
                            System.out.println("Quantidade insuficiente de ações disponíveis para compra.");
                        }
                    } else {
                        //vender um ativo
                        if (investidor.temAtivoNaCarteira(codigoAtivo, quantidade)) {
                            investidor.venderAtivo(codigoAtivo, quantidade);
                            acao.setQuantidade(acao.getQuantidade() + quantidade);
                            System.out.println(investidor.getNome() + " vendeu " + quantidade + " ações de " + codigoAtivo);
                        } else {
                            System.out.println("Investidor não possui a quantidade necessária do ativo na carteira para venda.");
                        }
                    }
                } else if (ativo instanceof Fundos) {
                    Fundos fundo = (Fundos) ativo;
                    double valorTransacao = quantidade * ativo.getPrecoAtual();
                    if (compra) {
                        if (fundo.getParticipacao() >= valorTransacao) {
                            fundo.setParticipacao(fundo.getParticipacao() - valorTransacao);
                            investidor.addAtivonaCarteira(new Fundos(codigoAtivo, ativo.getPrecoAtual(), ativo.getEmpresa(), valorTransacao), "1234");
                            System.out.println(investidor.getNome() + " comprou " + quantidade + " cotas do fundo " + codigoAtivo);
                        } else {
                            System.out.println("Saldo insuficiente para comprar cotas do fundo.");
                        }
                    } else {
                        if (investidor.temFundosNaCarteira(codigoAtivo, valorTransacao)) {
                            investidor.venderAtivo(codigoAtivo, valorTransacao);
                            fundo.setParticipacao(fundo.getParticipacao() + valorTransacao);
                            System.out.println(investidor.getNome() + " vendeu " + quantidade + " cotas do fundo " + codigoAtivo);
                        } else {
                            System.out.println("Investidor não possui fundos suficientes na carteira para venda.");
                        }
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
