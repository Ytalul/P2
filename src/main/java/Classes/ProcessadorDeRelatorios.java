package Classes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ProcessadorDeRelatorios {
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

    public void RelatorioPorcentagem(List<Requisicao> requisicoes){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("sistemasOperacionais.txt"))) {
            int contTotal=0; int contWindows=0; int contMacintosh=0; int contFedora=0; int contUbuntu=0; int contMobile=0; int contLinuxOutros=0;
            for (Requisicao req : requisicoes) {
                if (req.data.contains("2021")) {
                    contTotal = contTotal + 1;
                    if (req.sistemaOperacional == "Windows") {
                        contWindows++;
                    } else if (req.sistemaOperacional == "Macintosh") {
                        contMacintosh++;
                    } else if (req.sistemaOperacional == "Ubuntu"){
                        contUbuntu++;
                    } else if (req.sistemaOperacional == "Fedora") {
                        contFedora++;
                    } else if (req.sistemaOperacional == "Mobile") {
                        contMobile++;
                    } else if (req.sistemaOperacional == "Linux") {
                        contLinuxOutros++;
                    }
                }
            }
            writer.write("Windows "+String.format("%.4f", (double) 100*contWindows/contTotal) + "\n");
            writer.write("Macintosh " +String.format("%.4f", (double) 100*contMacintosh/contTotal)+"\n");
            writer.write("Ubuntu " +String.format("%.4f",(double) 100*contUbuntu/contTotal)+"\n");
            writer.write("Fedora " +String.format("%.4f",(double) 100*contFedora/contTotal)+"\n");
            writer.write("Mobile " +String.format("%.4f",(double) 100*contMobile/contTotal)+"\n");
            writer.write("Linux, outros "+String.format("%.4f",(double) 100*contLinuxOutros/contTotal)+"\n");

        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    public void MediaReq(List<Requisicao> requisicoes) {
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
        double media = count > 0 ? (double) totalSize / count : 0;
        System.out.println("A média dos tamanhos das requisições POST respondidas com sucesso em 2021 é: " + media);
    }

    public void NaoRespondidosNovembro(List<Requisicao> requisicoes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("naoRespondidosNovembro.txt"))) {
            int status;
            for (Requisicao requisicao : requisicoes) {
                try {
                    status = Integer.parseInt(requisicao.codigoStatus);
                } catch (NumberFormatException e) {
                    continue;
                }

                if (status >= 400 && status <= 499) {
                    if (requisicao.data != null && requisicao.data.contains("Nov/2021")) {
                        writer.write(requisicao.codigoStatus + " \"" + requisicao.urlReferencia + "\" Nov/2021\n"); //ta faltando melhorar o regex principal, ele nao pega tudo nao
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
