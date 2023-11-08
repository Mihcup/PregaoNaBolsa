package Bolsa;

public class Ativos {
    private String codigo;
    private double precoAtual;
    private String empresa;

    public Ativos(String codigo, double precoAtual, String empresa) {
        this.codigo = codigo;
        this.precoAtual = precoAtual;
        this.empresa = empresa;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getPrecoAtual() {
        return precoAtual;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setPrecoAtual(double precoAtual) {
        this.precoAtual = precoAtual;
    }

    @Override
    public String toString() {
        return
                "Codigo: " + codigo +
                        ", Preço Atual:"  + precoAtual+ ", Empresa: " + empresa;
    }
}

