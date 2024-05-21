package Classes;

import Interfaces.iMetodos;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Metodos implements iMetodos {

    @Override
    public void RecursoGrande(List<Requisicao> requisicoes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("recursosGrandes.txt"))) {
            for (Requisicao req : requisicoes) {
                if (Integer.parseInt(req.codigoStatus) >= 200 && Integer.parseInt(req.codigoStatus) < 300 && Integer.parseInt(req.tamanhoObjeto) > 2000) {
                    writer.write(req.codigoStatus + " " + req.tamanhoObjeto + " " + req.enderecoIp);
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
    public double MediaReq(List<Requisicao> requisicoes) {
        int totalSize = 0;
        int count = 0;

        for (Requisicao req : requisicoes) {
            if (req.tipoDeRequisicaoERecursoSolicitado.startsWith("POST") &&
                req.codigoStatus.startsWith("2") && // Código 2xx indica sucesso
                req.data.contains("2021")) {

                totalSize += Integer.parseInt(req.tamanhoObjeto);
                count++;
            }
        }

        return count > 0 ? (double) totalSize / count : 0;
    }
}
