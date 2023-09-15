import classes.*;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Main {
            public static void main(String[] args) {
//                Bolsa bolsa = new Bolsa("B3");
//                bolsa.adicionarAtivo(new Acoes("AAPL", 150.0, 100));
//                bolsa.adicionarAtivo(new Fundos("F1", 50.0, 10000.0));
//
//                Investidor investidor1 = new Investidor("Investidor1");
//                Investidor investidor2 = new Investidor("Investidor2");
//                Ativos ativo = new Acoes("APPL",150.0, 100);
//                investidor1.addCarteira(new Carteira("1234"));
//                investidor1.addAtivonaCarteira(new Acoes("AAPL", 150.0, 100),"1234");
//
//                Corretora corretora = new Corretora(bolsa);

                Investidor investidor1 = new Investidor("João Bittencourt");
                Ativos ativo1 = new Fundos("003H",12000.5, "KINEA CO-INVESTIMENTO FDO INV IMOB",12.0);
                Ativos ativo2 = new Fundos("0FEA", 1400, "SPIM FUNDO DE INVESTIMENTO IMOBILIÁRIO", 25.4);
                Ativos ativo3 = new Acoes("A2RR",1230.55, "ARROWHEAD PHARMACEUTICALS INC", 2);
                Ativos ativo4= new Acoes("AAGR", 30000.23, "ASSET BANK AGRONEGÓCIOS FIAGRO IMOBILIARIO", 5);
                Carteira carteira = new Carteira("CART0101");
                carteira.addAtivo(ativo1);
                carteira.addAtivo(ativo2);
                carteira.addAtivo(ativo3);
                carteira.addAtivo(ativo4);
                investidor1.addCarteira(carteira);
                Bolsa bolsa = new Bolsa("B3");
                Corretora corretora = new Corretora(bolsa);

                try {

                    RandomAccessFile investidores = new RandomAccessFile("investidores.txt", "rw");
                    investidores.seek(0);
                    investidores.writeUTF(investidor1.toString());

                    RandomAccessFile bolsas = new RandomAccessFile("bolsa.txt", "rw");
                    bolsas.seek(0);
                    bolsas.writeUTF(bolsa.toString());

                    RandomAccessFile ativos = new RandomAccessFile("ativos.txt", "rw");
                    ativos.seek(0);
                    ativos.writeUTF(ativo1.toString());
                    ativos.writeUTF(ativo2.toString());
                    ativos.writeUTF(ativo3.toString());
                    ativos.writeUTF(ativo4.toString());

                    RandomAccessFile carteiras = new RandomAccessFile("carteiras.txt", "rw");
                    carteiras.seek(0);
                    carteiras.writeUTF(carteira.toString());

                } catch (IOException e){
                    e.printStackTrace();
                }

                //testando métodos de remoção

                //removendo algo na primeira posição
                carteira.getAtivos().remove();
                //removendo da última posição
                carteira.getAtivos().removeLast();
                //removendo algo em qualque posição
                carteira.getAtivos().removeAtIndex(1);

                carteira.getAtivos().exibir();

            }
        }
