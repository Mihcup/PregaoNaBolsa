package bolsa;

import implementacoes.Lista;

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

    public void removeAtivo(Ativos a) {
        for(int i=0; i<ativos.getSize(); i++){
            Ativos ativo1 = ativos.retornarValor(i);
            if(ativo1.getCodigo()==a.getCodigo()){
                ativos.removeAtIndex(i);
            }
        }
    }


    public boolean temAtivo(String codigoAtivo) {
        for (int i = 0; i < ativos.getSize(); i++) {
            Ativos ativo = ativos.retornarValor(i);
            if (ativo.getCodigo().equals(codigoAtivo)) {
                return true;
            }
        }
        return false;
    }

    public void removerAtivo(String codigoAtivo) {
        for (int i = 0; i < ativos.getSize(); i++) {
            Ativos ativo = ativos.retornarValor(i);
            if (ativo.getCodigo().equals(codigoAtivo)) {
                ativos.removeAtIndex(i);
                return;
            }
        }
    }

    public boolean temFundo(String codigoFundo) {
        for (int i = 0; i < ativos.getSize(); i++) {
            Ativos ativo = ativos.retornarValor(i);
            if (ativo instanceof Fundos && ativo.getCodigo().equals(codigoFundo)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        String exibir;
        exibir = "Carteira \n" +
                "Codigo: " + codigo+ "\nAtivos: ";
        for (int i = 0; i < ativos.getSize(); i++) {
            Ativos a = ativos.retornarValor(i);
            exibir+= a.toString();
        }
        exibir+='\n';
        return exibir+'\n';
    }
}

