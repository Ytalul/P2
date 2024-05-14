package Interfaces;
import Classes.Requisicao;
import Classes.ManipuladorRequisicao;
import java.io.IOException;
import java.util.ArrayList;

public interface iManipuladorRequisicao {
    ArrayList<Requisicao> criarListaRequisicao(String caminhoArquivo) throws IOException;
}
