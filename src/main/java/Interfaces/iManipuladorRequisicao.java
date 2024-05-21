package Interfaces;
import Classes.Requisicao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface iManipuladorRequisicao {
    ArrayList<Requisicao> criarListaRequisicao() throws IOException;
    void RecursoGrande(List<Requisicao> requisicoes);
    double MediaReq(List<Requisicao> requisicoes) throws IOException;
}
