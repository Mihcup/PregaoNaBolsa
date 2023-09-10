import classes.*;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {
            public static void main(String[] args) {
                Bolsa bolsa = new Bolsa();
                bolsa.adicionarAtivo(new Acoes("AAPL", 150.0, 100));
                bolsa.adicionarAtivo(new Fundos("F1", 50.0, 10000.0));

                Investidor investidor1 = new Investidor("Investidor1");
                Investidor investidor2 = new Investidor("Investidor2");
                Ativos ativo = new Acoes("APPL",150.0, 100);
                investidor1.addCarteira(new Carteira("1234"));
                investidor1.addAtivonaCarteira(new Acoes("AAPL", 150.0, 100),"1234");

                Corretora corretora = new Corretora(bolsa);

                try {

                    RandomAccessFile investidores = new RandomAccessFile("investidores.txt", "rw");
                    investidores.seek(0);
                    investidores.writeUTF(investidor1.toString());
                    investidores.writeUTF(investidor2.toString());
                    RandomAccessFile bolsas = new RandomAccessFile("bolsa.txt", "rw");
                    bolsas.seek(0);
                    bolsas.writeUTF(bolsa.toString());


                    //conseguir exibir as coisas da lista

//                    arquivo.seek(0);
//                    byte [] buffer = new byte [49];
//                    arquivo.read(buffer);
//
//                    System.out.println(new String(buffer));
//                    arquivo.read(buffer);
//                    System.out.println(new String(buffer));

                } catch (IOException e){
                    e.printStackTrace();
                }

            }
        }
