package Classes;

import Interfaces.iMetodos;
import java.util.List;

public class Metodos implements iMetodos {

    @Override
    public void RecursoGrande(List<Requisicao> requisicoes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("recursosGrandes.txt"))) {
            for (Requisicao req : requisicoes) {
                if (req.getCodigoResposta() >= 200 && req.getCodigoResposta() < 300 && req.getTamanhoObjeto() > 2000) {
                    writer.write(req.getCodigoResposta() + " " + req.getTamanhoObjeto() + " " + req.getEnderecoIP());
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
