package bolsa;
import formatacao.Formation;
import implementacoes.Lista;

public class Investidor {
    private String nome;
    private String codigoDeAcesso;
    private String CPF;
    private String telefone;
    private double saldo;
    private Carteira carteira;



    public Investidor(String nome, String codigoDeAcesso, String CPF, String telefone, double saldo, Carteira carteira) {
        this.nome = nome;
        this.codigoDeAcesso = codigoDeAcesso;
        this.CPF = Formation.formatCPF(CPF);
        this.telefone = Formation.FormatTelefone(telefone);
        this.saldo = saldo;
        this.carteira = carteira;
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

    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }

    public Carteira getCarteiras() {
        return carteira;
    }



    public void addAtivonaCarteira(Ativos a) {
                carteira.addAtivo(a);
    }
        public void removeAtivonaCarteira(Ativos a) {
                carteira.removeAtivo(a);
            }
    @Override
    public String toString() {
        String exibir;
        exibir = "\n\nInvestidor: " +
                "Nome: " + nome +
                "\nCódigo de acesso: "+codigoDeAcesso+
                "\nCPF: "+ CPF+
                "\nTelefone: "+ telefone+ "\nCarteira: "+carteira;
        return exibir;
    }

    public void enviarOrdemCompra(Corretora corretora, Ativos ativo, int quantidade) {
        corretora.processarOrdemCompra(this, ativo, quantidade);
    }

    public void enviarOrdemVenda(Corretora corretora, Ativos ativo) {
        corretora.processarOrdemVenda(this, ativo);
    }
}









