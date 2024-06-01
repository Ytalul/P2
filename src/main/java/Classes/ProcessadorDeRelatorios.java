package Classes;

import java.util.List;

public class ProcessadorDeRelatorios {
    private ManipuladorArquivo manipuladorArquivo = new ManipuladorArquivo();

    public void RecursosGrandes(List<Requisicao> requisicoes) {
        manipuladorArquivo.abrirArquivoParaEscrita("recursosGrandes.txt");
        for (Requisicao req : requisicoes) {
            if (Integer.parseInt(req.codigoStatus) >= 200 && Integer.parseInt(req.codigoStatus) < 300 && Integer.parseInt(req.tamanhoObjeto) > 2000) {
                manipuladorArquivo.escreverNoArquivo(req.codigoStatus + " " + req.tamanhoObjeto + " " + req.enderecoIp);
            }
        }
        manipuladorArquivo.fecharArquivoEscrita();
    }

    public void RelatorioPorcentagem(List<Requisicao> requisicoes) {
        manipuladorArquivo.abrirArquivoParaEscrita("sistemasOperacionais.txt");
        int contTotal = 0, contWindows = 0, contMacintosh = 0, contFedora = 0, contUbuntu = 0, contMobile = 0, contLinuxOutros = 0;
        for (Requisicao req : requisicoes) {
            if (req.data.contains("2021")) {
                contTotal++;
                switch (req.sistemaOperacional) {
                    case "Windows": contWindows++; break;
                    case "Macintosh": contMacintosh++; break;
                    case "Ubuntu": contUbuntu++; break;
                    case "Fedora": contFedora++; break;
                    case "Mobile": contMobile++; break;
                    case "Linux": contLinuxOutros++; break;
                }
            }
        }
        manipuladorArquivo.escreverNoArquivo("Windows " + String.format("%.4f", (double) 100 * contWindows / contTotal));
        manipuladorArquivo.escreverNoArquivo("Macintosh " + String.format("%.4f", (double) 100 * contMacintosh / contTotal));
        manipuladorArquivo.escreverNoArquivo("Ubuntu " + String.format("%.4f", (double) 100 * contUbuntu / contTotal));
        manipuladorArquivo.escreverNoArquivo("Fedora " + String.format("%.4f", (double) 100 * contFedora / contTotal));
        manipuladorArquivo.escreverNoArquivo("Mobile " + String.format("%.4f", (double) 100 * contMobile / contTotal));
        manipuladorArquivo.escreverNoArquivo("Linux, outros " + String.format("%.4f", (double) 100 * contLinuxOutros / contTotal));
        manipuladorArquivo.fecharArquivoEscrita();
    }

    public void MediaReq(List<Requisicao> requisicoes) {
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

    public void NaoRespondidosNovembro(List<Requisicao> requisicoes) {
        manipuladorArquivo.abrirArquivoParaEscrita("naoRespondidosNovembro.txt");
        int status;
        for (Requisicao requisicao : requisicoes) {
            try {
                status = Integer.parseInt(requisicao.codigoStatus);
            } catch (NumberFormatException e) {
                continue;
            }

            if (status >= 400 && status <= 499 && requisicao.data != null && requisicao.data.contains("Nov/2021")) {
                manipuladorArquivo.escreverNoArquivo(requisicao.codigoStatus + " \"" + requisicao.urlReferencia + "\" Nov/2021");
            }
        }
        manipuladorArquivo.fecharArquivoEscrita();
    }
}
