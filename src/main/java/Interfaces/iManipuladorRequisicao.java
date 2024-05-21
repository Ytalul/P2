package Interfaces;
import Classes.Requisicao;
import java.io.IOException;
import java.util.ArrayList;

public interface iManipuladorRequisicao {
    ArrayList<Requisicao> criarListaRequisicao() throws IOException;
}
