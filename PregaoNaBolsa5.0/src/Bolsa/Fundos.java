package Bolsa;

public class Fundos extends Ativos {
    private double participacao;

    public Fundos(String codigo, double precoAtual, String empresa, double participacao) {
        super(codigo, precoAtual, empresa);
        this.participacao = participacao;
    }

    public double getParticipacao() {
        return participacao;
    }

    public void setParticipacao(double participacao) {
        this.participacao = participacao;
    }

    @Override
    public String toString() {
        return "Fundo: " +super.toString() +
                "Participação: " + participacao +
                '\n';
    }
}
