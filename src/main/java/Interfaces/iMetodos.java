package Interfaces;

import java.io.IOException;
import java.util.List;
import Classes.Requisicao;

public interface iMetodos {
    void RecursoGrande(List<Requisicao> requisicoes);

    double MediaReq(List<Requisicao> requisicoes) throws IOException;
}
