import classes.*;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {
            public static void main(String[] args) {
                Bolsa bolsa = new Bolsa("B3");
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


                } catch (IOException e){
                    e.printStackTrace();
                }

            }
        }
