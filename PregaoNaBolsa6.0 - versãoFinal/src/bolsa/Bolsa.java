package bolsa;

import implementacoes.Lista;

public class Bolsa {
    private String nome;
    private static Lista<Ativos> ativosAVenda;

    public Bolsa(String nome) {
        this.nome = nome;
        this.ativosAVenda = new Lista();
    }

    //compra de um ativo
    public void processarOrdemCompra(Investidor investidorComprador, Ativos ativo, int quantidade) {
       Investidor investidorC = investidorComprador;
        for(int i =0; i<ativosAVenda.getSize(); i++){
            Ativos a = ativosAVenda.retornarValor(i);
            if(a.getCodigo()==ativo.getCodigo()){
                if((ativo.getQuantidade()>=quantidade)){
                    a.setQuantidade(a.getQuantidade()-quantidade);
                    // investidor vendedor
                    a.getInvestidor().setSaldo(a.getInvestidor().getSaldo()+ativo.getPrecoAtual());
                    System.out.println("O investidor "+a.getInvestidor().getNome()+" vendeu o ativo "+a.getCodigo());
                    //investidor comprador
                    investidorComprador.setSaldo(investidorComprador.getSaldo()-ativo.getPrecoAtual());
                    Acoes ac = new Acoes(a.getCodigo(),a.getPrecoAtual(),a.getEmpresa(),investidorC,quantidade);
                    investidorComprador.addAtivonaCarteira(ac);
                    System.out.println("O investidor "+investidorC.getNome()+" comprou o ativo "+a.getCodigo());
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Bolsa: " +
                "Nome: '" + nome+"\n";
    }

    //venda de um ativo
    public void processarOrdemVenda(Investidor investidor, Ativos ativo) {
        if(ativo.getInvestidor().getCodigoDeAcesso()!=""){
            ativosAVenda.add(ativo);
        }
    }
}
