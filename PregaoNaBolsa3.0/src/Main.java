import ArquivosDeTexto.SalvarEmArquivo;
import Bolsa.Investidor;

import java.io.IOException;
import java.util.Scanner;
public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        Menus();
    }

    public static void Menus() throws IOException {
        System.out.println("Bem vindo a bolsa de valores!");
        System.out.printf("Cadastro do investidor: \nNome: ");
        String nomeInvestidor = scan.nextLine();
        System.out.printf("\nCódigo de acesso: ");
        String codigoDeAcesso = scan.nextLine();
        System.out.printf("\nCPF: ");
        String CPFdoInvestidor = scan.nextLine();
        System.out.printf("\nTelefone: ");
        String TelefoneDoInvestidor = scan.nextLine();

        Investidor investidor = new Investidor(nomeInvestidor,codigoDeAcesso,CPFdoInvestidor,TelefoneDoInvestidor);
        SalvarEmArquivo.Salvar(1,investidor);
    }

}