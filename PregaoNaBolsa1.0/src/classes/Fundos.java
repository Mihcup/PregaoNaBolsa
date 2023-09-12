package classes;

public class Fundos extends Ativos {
    private double participacao;

    public Fundos(String codigo, double precoAtual, double participacao) {
        super(codigo, precoAtual);
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
