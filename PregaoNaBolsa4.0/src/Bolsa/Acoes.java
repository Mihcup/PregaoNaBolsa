package Bolsa;

public class Acoes extends Ativos {
    private int quantidade;

    public Acoes(String codigo, double precoAtual,String empresa, int quantidade) {
        super(codigo, precoAtual, empresa);
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        String acao = "Ação: "+super.toString()+ "Quantidade: " + quantidade+"\n";
        return acao;
    }
}
