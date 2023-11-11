package ArquivosDeTexto;

import Bolsa.*;
import Implementacoes.Lista;

import java.io.IOException;
import java.io.RandomAccessFile;

public class SalvarEmArquivo {
    public static void Salvar(int op, Lista<Object> ob) throws IOException {
        int cont = 0;
        switch (op){
            case 1: {
                RandomAccessFile investidores = new RandomAccessFile("investidores.txt", "rw");
                investidores.setLength(0);
                for (int i = 0; i <ob.getSize(); i++) {
                    Investidor investidor = (Investidor) ob.retornarValor(i);
                    investidores.seek(cont);
                    investidores.writeUTF(investidor.toString()+'\n');
                    cont+=investidor.toString().length();
                }
            }
            break;
            case 2:{
                for (int i = 0; i <ob.getSize(); i++) {
                    Ativos ativo = (Ativos) ob.retornarValor(i); //retorna valor na posição do i
                    RandomAccessFile ativos = new RandomAccessFile("ativos.txt", "rw");
                    ativos.seek(cont);
                    ativos.writeUTF("\n\n"+ativo.toString());
                    cont+=ativo.toString().length()+10;
                }
            }
            break;
            case 3:{
                for (int i = 0; i <ob.getSize(); i++) {
                    Bolsa bolsa = (Bolsa) ob.retornarValor(i); //retorna valor na posição do i
                    RandomAccessFile bolsas = new RandomAccessFile("bolsas.txt", "rw");
                    bolsas.seek(cont);
                    bolsas.writeUTF(bolsa.toString());
                    cont+=bolsa.toString().length();
                }
            }
            break;
            case 4:{
                for (int i = 0; i <ob.getSize(); i++) {
                    Carteira carteira = (Carteira) ob.retornarValor(i); //retorna valor na posição do i
                    RandomAccessFile carteiras = new RandomAccessFile("carteiras.txt", "rw");
                    carteiras.seek(cont);
                    carteiras.writeUTF(carteira.toString());
                    cont+=carteira.toString().length();
                }
            }
            break;
        }
    }


    public static void Recuperar(){

    }


    public static void lerDadosDoArquivo(String nomeDoArquivo) throws IOException {
        try (RandomAccessFile arquivo = new RandomAccessFile(nomeDoArquivo, "r")) {
            byte[] bytes = new byte[(int) arquivo.length()];
            arquivo.readFully(bytes);
            String lala = new String(bytes, "UTF-8");
            System.out.printf(lala);
        }
    }
    public static void Deletar(){

    }
}

