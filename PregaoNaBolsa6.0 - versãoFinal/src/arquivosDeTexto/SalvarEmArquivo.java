package arquivosDeTexto;

import bolsa.*;
import implementacoes.Lista;

import java.io.IOException;
import java.io.RandomAccessFile;

public class SalvarEmArquivo {
    public static void Salvar(int op, Lista<Object> ob) throws IOException {
        switch (op){
            case 1: {

                RandomAccessFile investidores = new RandomAccessFile("investidores.txt", "rw");
                for (int i = 0; i <ob.getSize(); i++) {
                    int cont1 = (int) investidores.length();
                    Investidor investidor = (Investidor) ob.retornarValor(i);
                    investidores.seek(cont1);
                    investidores.writeUTF(investidor.toString()+'\n');
                }
            }
            break;
            case 2:{
                for (int i = 0; i <ob.getSize(); i++) {
                    Ativos ativo = (Ativos) ob.retornarValor(i); //retorna valor na posição do i
                    RandomAccessFile ativos = new RandomAccessFile("ativos.txt", "rw");
                    int cont2 = (int) ativos.length();
                    ativos.seek(cont2);
                    ativos.writeUTF("\n\n"+ativo.toString());
                }
            }
            break;
            case 3:{
                for (int i = 0; i <ob.getSize(); i++) {
                    Bolsa bolsa = (Bolsa) ob.retornarValor(i); //retorna valor na posição do i
                    RandomAccessFile bolsas = new RandomAccessFile("bolsas.txt", "rw");
                    int cont3 = (int) bolsas.length();
                    bolsas.seek(cont3);
                    bolsas.writeUTF(bolsa.toString());
                }
            }
            break;
            case 4:{
                for (int i = 0; i <ob.getSize(); i++) {
                    Carteira carteira = (Carteira) ob.retornarValor(i); //retorna valor na posição do i
                    RandomAccessFile carteiras = new RandomAccessFile("carteiras.txt", "rw");
                    int cont4 = (int) carteiras.length();
                    carteiras.seek(cont4);
                    carteiras.writeUTF(carteira.toString());
                }
            }
            break;
            case 5:{
                for (int i = 0; i <ob.getSize(); i++) {
                    Corretora corretora = (Corretora) ob.retornarValor(i); //retorna valor na posição do i
                    RandomAccessFile corretoras = new RandomAccessFile("corretoras.txt", "rw");
                    int cont5 = (int) corretoras.length();
                    corretoras.seek(cont5);
                    corretoras.writeUTF(corretora.toString());
                }
            }
            break;
        }
    }
}


