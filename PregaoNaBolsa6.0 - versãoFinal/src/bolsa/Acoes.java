package bolsa;

public class Acoes extends Ativos {

    public Acoes(String codigo, double precoAtual,String empresa, Investidor investidor,int quantidade) {
        super(codigo, precoAtual, empresa, investidor,quantidade);
    }


    @Override
    public String toString() {
        String acao = "Ação: "+super.toString()+"\n";
        return acao;
    }
}
