package Bolsa;
import Formatacao.Formation;
import Implementacoes.Lista;

public class Investidor {
    private Integer id;
    private static Integer idBase;
    private String nome;
    private String codigoDeAcesso;
    private String CPF;
    private String telefone;
    private double saldo;

    private Lista<Carteira> carteiras = new Lista<>();


    public Investidor(String nome, String codigoDeAcesso, String CPF, String telefone) {
        this.nome = nome;
        this.codigoDeAcesso = codigoDeAcesso;
        this.CPF = Formation.formatCPF(CPF);
        this.telefone = Formation.FormatTelefone(telefone);
        id = idBase;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
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


    public boolean temAtivonaCarteira(String codigoAtivo) {
        for (int i = 0; i < carteiras.getSize(); i++) {
            Carteira c = carteiras.retornarValor(i);
            if (c.temAtivo(codigoAtivo)) {
                return true;
            }
        }
        return false;
    }

    public void addCarteira(Carteira c) {
        carteiras.add(c);
    }

    @Override
    public String toString() {
        String exibir;
        exibir = "\n\nInvestidor: " +
                "Id: " +id+
                "Nome: " + nome +
                "\nCódigo de acesso: "+codigoDeAcesso+
                "\nCPF: "+ CPF+
                "\nTelefone: "+ telefone+ "\nCarteiras: ";
        for (int i = 0; i < carteiras.getSize(); i++) {
            Carteira c = carteiras.retornarValor(i);
            exibir += c.toString();
        }
        exibir += "\n";
        return exibir+"\n";
    }



    public int tamanhoRegistro(){
        return toString().length();
    }

    public boolean temFundosNaCarteira(String codigoAtivo, double valorVenda) {
        boolean condicao = false;
        for (int i = 0; i < carteiras.getSize(); i++){
            Carteira c = carteiras.retornarValor(i);
            condicao = c.temFundo(codigoAtivo);
        }
       return condicao;
    }

    public boolean temAtivoNaCarteira(String codigoAtivo) {
        boolean condicao = false;
        for (int i = 0; i < carteiras.getSize(); i++){
            Carteira c = carteiras.retornarValor(i);
            condicao = c.temAtivo(codigoAtivo);
        }
        return condicao;
    }

    public boolean temAtivoNaCarteira(String codigoAtivo,int quantidade) {
        boolean condicao = false;
        for (int i = 0; i < carteiras.getSize(); i++){
            Carteira c = carteiras.retornarValor(i);
            condicao = c.temAtivo(codigoAtivo);
        }
        return condicao;
    }
}
