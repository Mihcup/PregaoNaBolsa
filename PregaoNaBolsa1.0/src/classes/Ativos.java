package classes;

import java.util.ArrayList;
import java.util.List;

public class Ativos {
    private String codigo;
    private double precoAtual;

    public Ativos(String codigo, double precoAtual) {
        this.codigo = codigo;
        this.precoAtual = precoAtual;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getPrecoAtual() {
        return precoAtual;
    }

    public void setPrecoAtual(double precoAtual) {
        this.precoAtual = precoAtual;
    }

    @Override
    public String toString() {
        return
                "Codigo: " + codigo +
                ", Preço Atual:"  + precoAtual+ ", "
                ;
    }
}
