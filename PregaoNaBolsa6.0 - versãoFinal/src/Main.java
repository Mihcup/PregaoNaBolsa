import arquivosDeTexto.SalvarEmArquivo;
import bolsa.*;
import implementacoes.Lista;
import sorting.BubbleSort;
import sorting.ShellSort;

import java.io.IOException;
import java.util.Scanner;
public class Main {
    static Lista<Object>  investLista = new Lista<>();
    static Lista<Object>  acoesEmVenda = new Lista<>();

    static Lista<Object> ativos= new Lista<>();
    static Lista<Object> carteiras= new Lista<>();
    static Lista<Object> bolsas = new Lista<>();
    static Lista<Object> corretoras = new Lista<>();

    //Bolsa
    static Bolsa bolsa = new Bolsa("B3");
    //Corretora
    static Corretora corretora = new Corretora("DedigadosCorreta",bolsa);
    static Scanner scan = new Scanner(System.in);


    public static void main(String[] args) throws IOException {
        System.out.println("Bem vindo ao pregão M&J - simulador de um pregão na bolsa de valores");
        Menu();
    }

    public static void Menu() throws IOException {
       //salvando numa lista para depois passar para o arquvivo de texto
        corretoras.add(corretora);
        bolsas.add(bolsa);

        //carteiras:
        Carteira c1 = new Carteira("2394");
        Carteira c2 = new Carteira("0308");
        Carteira c3 = new Carteira("2606");
        Carteira c4 = new Carteira("2405");
        carteiras.add(c1);
        carteiras.add(c2);
        carteiras.add(c3);
        carteiras.add(c4);

        //investidores
        Investidor i1 = new Investidor("João Félix","123ef","12345678910","11978123478",1220.00,c1);
        Investidor i2 = new Investidor("Jo Tavares","345tm","01987654321","11914326789",1500.00,c2);
        Investidor i3 = new Investidor("Maris Mayu","890mm","45612378912","11905713214",2000.00,c3);
        Investidor i4 = new Investidor("Millena Cupolillo","567mc","45678932154","11908732145",2007.00,c4);
        investLista.add(i1);
        investLista.add(i2);
        investLista.add(i3);
        investLista.add(i4);

        //ativos
        Ativos a1 = new Acoes("PETZ3",10.00,"Petz",i1,2);
        i1.addAtivonaCarteira(a1);
        Ativos a2 = new Acoes("PETR3",150.00,"Petrobrás",i2,11);
        i2.addAtivonaCarteira(a2);
        Ativos a3 = new Acoes("SBSP3",24.00,"Sabesp",i3,3);
        i3.addAtivonaCarteira(a3);
        Ativos a4 = new Acoes("SANB11",123.00,"Santander",i4,4);
        i4.addAtivonaCarteira(a4);
        Ativos a5 = new Acoes("ARZZ3",89.00,"Arezzo",i1,1);
        i1.addAtivonaCarteira(a5);
        Ativos a6 = new Acoes("CYRE3",60.00,"Cyrela",i2,12);
        i2.addAtivonaCarteira(a6);
        Ativos a7 = new Acoes("MULT3",50.00,"Mulpipan",i3,3);
        i3.addAtivonaCarteira(a7);
        Ativos a8 = new Acoes("TIMS3",38.90,"Tim",i4,4);
        i4.addAtivonaCarteira(a8);
        Ativos a9 = new Acoes("NTCO3",50.00,"Natura & CO",i1,1);
        i1.addAtivonaCarteira(a9);
        Ativos a10 = new Acoes("BBSE3",18.00,"BB Seguridade",i2,6);
        i2.addAtivonaCarteira(a10);
        Ativos a11 = new Acoes("ENBR3",54.00,"Energias do Brasil",i3,16);
        i3.addAtivonaCarteira(a11);
        Ativos a12 = new Acoes("GOAU4",80.00,"Metalúrgica Gerdau",i4,9);
        i4.addAtivonaCarteira(a12);
        Ativos a13 = new Acoes("VALE3",80.00,"Vale",i1,2);
        i1.addAtivonaCarteira(a13);
        Ativos a14 = new Acoes("VIVT3",80.00,"Telefônica Brasil",i2,5);
        i2.addAtivonaCarteira(a14);
        ativos.add(a1);
        ativos.add(a2);
        ativos.add(a3);
        ativos.add(a4);
        ativos.add(a5);
        ativos.add(a6);
        ativos.add(a7);
        ativos.add(a8);
        ativos.add(a9);
        ativos.add(a10);
        ativos.add(a11);
        ativos.add(a12);
        ativos.add(a13);
        ativos.add(a14);

        //OrdemdeVenda
        i1.enviarOrdemVenda(corretora,a1);
        i2.enviarOrdemVenda(corretora,a2);
        i3.enviarOrdemVenda(corretora,a3);
        i4.enviarOrdemVenda(corretora,a4);
        acoesEmVenda.add((Acoes) a1);
        acoesEmVenda.add((Acoes) a2);
        acoesEmVenda.add((Acoes) a3);
        acoesEmVenda.add((Acoes) a4);

        //percorrer a lista de investidores para saber se esse investidor já existe
        System.out.println("Já está cadastrado? Se sim, digite seu código de acesso: ");
        String codigodeAcesso = scan.nextLine();
        boolean achou = false;
        Investidor investidorAchado = null;
        for(int i=0; i<investLista.getSize(); i++){
            Investidor investidor = (Investidor) investLista.retornarValor(i);
            if(codigodeAcesso.equals(investidor.getCodigoDeAcesso())){
                achou=true;
                investidorAchado = (Investidor) investLista.retornarValor(i);
            } }
        if(achou) {
            MenuNegociacao(investidorAchado);
        }

            else {
                System.out.printf("Cadastro do investidor: \nNome: ");
                String nomeInvestidor = scan.nextLine();
                System.out.printf("\nCódigo de acesso: ");
                String codigoDeAcesso = scan.nextLine();
                System.out.printf("\nCPF: ");
                String CPFdoInvestidor = scan.nextLine();
                System.out.printf("\nTelefone: ");
                String TelefoneDoInvestidor = scan.nextLine();
                System.out.println("\n Qual o seu saldo? ");
                double saldoInvestidor = scan.nextDouble();
                System.out.println("Como você é novo por aqui, crie um código para sua carteira já: ");
                String codigoCarteira = scan.nextLine();
                Carteira carteira = new Carteira(codigoCarteira);
                carteiras.add(carteira);

                Investidor invest = new Investidor(nomeInvestidor,codigoDeAcesso,CPFdoInvestidor,TelefoneDoInvestidor,saldoInvestidor,carteira);
                System.out.println("Deseja criar outro investidor? Se sim digite qualquer tecla, ao contrário digite 0");
                investLista.add(invest);
                MenuNegociacao(invest);
            }
        }
        public static void MenuNegociacao(Investidor investidor) throws IOException{
        for(int i=0; i<acoesEmVenda.getSize();i++){
            System.out.println(acoesEmVenda.retornarValor(i));
        }

        System.out.println("Digite o código da ação que deseja comprar!");
        String codigo = scan.nextLine();
        System.out.println("Qual a quantidade deseja comprar?");
        int qtd = scan.nextInt();

        for(int i =0;i<acoesEmVenda.getSize();i++){
            Acoes a = (Acoes) acoesEmVenda.retornarValor(i);
            if(a.getCodigo().equals(codigo)){
                investidor.enviarOrdemCompra(corretora,a,qtd);
            }
        }

            //salvando os dados em arquivo
            SalvarEmArquivo.Salvar(1,investLista);
            SalvarEmArquivo.Salvar(2,ativos);
            SalvarEmArquivo.Salvar(3,bolsas);
            SalvarEmArquivo.Salvar(4,carteiras);
            SalvarEmArquivo.Salvar(5,corretoras);
            System.out.println("Ordenações:\n\n");
            sorting();
    }

    //uso do sorting
    public static void sorting(){
        // top 10 ações mais movimentadas
        Lista<Acoes> acoes = new Lista<Acoes>();
        for (int i=0; i< ativos.getSize();i++) {
            Object o = ativos.retornarValor(i);
            if (o instanceof Acoes) {
                Acoes acao = (Acoes) o; // Converte o objeto para Acoes
                acoes.add(acao); // Adiciona o objeto convertido à nova lista
            }
        }
        System.out.println("Top 10 ações mais vendidas:");
        BubbleSort.sortTop10AcoesMaisVendidas(acoes);

        // ordenar os investidores pelo nome
        Lista<Investidor> investidores = new Lista<Investidor>();
        for (int i=0; i< investLista.getSize();i++) {
            Object o = investLista.retornarValor(i);
            if (o instanceof Investidor) {
                Investidor inv = (Investidor) o; // Converte o objeto para Acoes
                investidores.add(inv); // Adiciona o objeto convertido à nova lista
            }
        }
        System.out.println("Investidores ordenados por orddem alfabética:");
        ShellSort.sortInvestidoresPorNome(investidores); //ordenou
        for(int i=0; i< investidores.getSize();i++){
            Investidor investidor = investidores.retornarValor(i);
            System.out.println(investidor.getNome());
        }
    }
}
