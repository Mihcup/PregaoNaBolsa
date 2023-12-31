import ArquivosDeTexto.SalvarEmArquivo;
import Bolsa.Acoes;
import Bolsa.Ativos;
import Bolsa.Carteira;
import Bolsa.Investidor;
import Implementacoes.Lista;

import java.io.IOException;
import java.util.Scanner;
public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        MenuInvestidor();
    }

    public static void MenuInvestidor() throws IOException {
        int i = 0;
        Lista<Object> investLista= new Lista<>();

            System.out.println("Bem vindo a bolsa de valores!");
            System.out.printf("Cadastro do investidor: \nNome: ");
            String nomeInvestidor = scan.nextLine();
            System.out.printf("\nCódigo de acesso: ");
            String codigoDeAcesso = scan.nextLine();
            System.out.printf("\nCPF: ");
            String CPFdoInvestidor = scan.nextLine();
            System.out.printf("\nTelefone: ");
            String TelefoneDoInvestidor = scan.nextLine();

            Investidor invest = new Investidor(nomeInvestidor,codigoDeAcesso,CPFdoInvestidor,TelefoneDoInvestidor);
            MenuNegociacao(invest);
            investLista.add(invest);
            SalvarEmArquivo.Salvar(1,investLista);
    }

    public static void MenuNegociacao(Investidor investidor) throws IOException {
        Lista<Object> ativos= new Lista<>();

        Ativos a1 = new Acoes("PETZ3",10.00,"Petz",2);
        Ativos a2 = new Acoes("PETR3",150.00,"Petrobrás",11);
        Ativos a3 = new Acoes("SBSP3",24.00,"Sabesp",3);
        Ativos a4 = new Acoes("SANB11",123.00,"Santander",4);
        ativos.add(a1);
        ativos.add(a2);
        ativos.add(a3);
        ativos.add(a4);
        SalvarEmArquivo.Salvar(2,ativos);

        System.out.println("Tabela de ativos:\n");

        for (int i = 0; i < ativos.getSize(); i++) {
            System.out.println( (i+1)+" - "+ ativos.retornarValor(i));
        }

        System.out.println("Selecione a opção de ativo para a compra:");
        int op = scan.nextInt();

        switch (op){
            case 1:{
                investidor.addCarteira(new Carteira("set"));
                investidor.addAtivonaCarteira(a1,"set");
                break;
            }
            case 2:{
                investidor.addCarteira(new Carteira("gegr"));
                investidor.addAtivonaCarteira(a2,"gegr");
                break;
            }
            case 3:{
                investidor.addCarteira(new Carteira("asd"));
                investidor.addAtivonaCarteira(a3,"asd");
                break;
            }
            case 4:{
                investidor.addCarteira(new Carteira("wetr"));
                investidor.addAtivonaCarteira(a4,"wetr");
                break;
            }

        }
    }

}