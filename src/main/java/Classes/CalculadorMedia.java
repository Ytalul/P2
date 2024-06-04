package Classes;

import java.util.List;

public class CalculadorMedia {

    public void calcularMediaReq(List<Requisicao> requisicoes) {
        int totalSize = 0;
        int count = 0;

        for (Requisicao req : requisicoes) {
            if (req.tipoDeRequisicaoERecursoSolicitado.startsWith("POST") &&
                    req.codigoStatus.startsWith("2") &&
                    req.data.contains("2021")) {

                totalSize += Integer.parseInt(req.tamanhoObjeto);
                count++;
            }
        }
        double media = count > 0 ? (double) totalSize / count : 0;
        System.out.println("A média dos tamanhos das requisições POST respondidas com sucesso em 2021 é: " + media);
    }
}
