package ArquivosDeTexto;

import Bolsa.*;

import java.io.IOException;
import java.io.RandomAccessFile;

public class SalvarEmArquivo {
    public static void Salvar(int op, Object ob ) throws IOException {
        switch (op){
            case 1: {
                RandomAccessFile investidores = new RandomAccessFile("investidores.txt", "rw");
                investidores.setLength(0);
                investidores.seek(0);
                Investidor investidor = (Investidor) ob;
                investidores.writeUTF(investidor.toString());
            }
            break;
            case 2:{
                RandomAccessFile ativos = new RandomAccessFile("ativos.txt", "rw");
                ativos.seek(0);
                Ativos ativo = (Ativos) ob;
                ativos.writeUTF(ativo.toString());
            }
            break;
            case 3:{
                RandomAccessFile bolsas = new RandomAccessFile("bolsa.txt", "rw");
                bolsas.seek(0);
                Bolsa bolsa = (Bolsa) ob;
                bolsas.writeUTF(bolsa.toString());
            }
            break;
            case 4:{
                RandomAccessFile carteiras = new RandomAccessFile("carteiras.txt", "rw");
                carteiras.seek(0);
                Carteira carteira = (Carteira) ob;
                carteiras.writeUTF(carteira.toString());
            }
            break;
        }

    }
}

