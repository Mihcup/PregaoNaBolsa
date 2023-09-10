package classes;

import ImplementacaoLista.Lista;

public class Carteira {
    private String codigo;
    private Lista<Ativos> ativos = new Lista<>();

    public Carteira(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public Lista<Ativos> getAtivos() {
        return ativos;
    }

    public void addAtivo(Ativos a) {
        ativos.add(a);
    }


    @Override
    public String toString() {
        String exibir;
        exibir = "Carteira{" +
                "codigo: " + codigo+ "ativos: ";
        for (int i = 0; i < ativos.getSize(); i++) {
            Ativos a = ativos.retornarValor(i);
            exibir+= a.toString()+", ";
        }
        return exibir;
        }
    }

