package Bolsa;
import Bolsa.Ativos;
import Bolsa.Carteira;
import Bolsa.Corretora;
import Formatacao.Formation;
import Implementacoes.Lista;

public class Investidor {
    private String nome;
    private String codigoDeAcesso;
    private String CPF;
    private String telefone;

    private Lista<Carteira> carteiras = new Lista<>();


    public Investidor(String nome, String codigoDeAcesso, String CPF, String telefone) {
        this.nome = nome;
        this.codigoDeAcesso = codigoDeAcesso;
        this.CPF = Formation.formatCPF(CPF);
        this.telefone = Formation.FormatTelefone(telefone);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoDeAcesso() {
        return codigoDeAcesso;
    }

    public void setCodigoDeAcesso(String codigoDeAcesso) {
        this.codigoDeAcesso = codigoDeAcesso;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setCarteiras(Lista<Carteira> carteiras) {
        this.carteiras = carteiras;
    }

    public void enviarOrdemCompra(Corretora corretora, String codigoAtivo, int quantidade, double precoMaximo) {
        corretora.processarOrdemCompra(this, codigoAtivo, quantidade, precoMaximo);
    }

    public Lista<Carteira> getCarteiras() {
        return carteiras;
    }

    public void addAtivonaCarteira(Ativos a, String codigo) {
        for (int i = 0; i < carteiras.getSize(); i++) {
            Carteira c = carteiras.retornarValor(i);
            if (c.getCodigo().equals(codigo)) {
                c.addAtivo(a);
            }
        }
    }

    public void addCarteira(Carteira c) {
        carteiras.add(c);
    }

    @Override
    public String toString() {
        String exibir;
        exibir = "Investidor: " +
                "Nome: " + nome +
                "\nCódigo de acesso: "+codigoDeAcesso+
                "\nCPF: "+ CPF+
                "\nTelefone: "+ telefone+ "\nCarteiras: ";
        for (int i = 0; i < carteiras.getSize(); i++) {
            Carteira c = carteiras.retornarValor(i);
            exibir += c.toString();
        }
        exibir += "\n";
        return exibir;
    }
}