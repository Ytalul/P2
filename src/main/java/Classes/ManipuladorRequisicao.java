package Classes;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Interfaces.iManipuladorRequisicao;
public class ManipuladorRequisicao implements iManipuladorRequisicao {

    public ArrayList<Requisicao> criarListaRequisicao() throws IOException {
        ArrayList<Requisicao> listaRequisicao = new ArrayList<Requisicao>();

        try {
            File arquivo = new File("C:\\Users\\ytalo\\Downloads\\access.log");
            FileReader fileReader = new FileReader(arquivo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String regex = "^(\\S+) (\\S+) (\\S+) \\[([^\\]]+)\\] \"(\\S+ \\S+ \\S+)\" (\\d{3}) (\\d+) \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$";
            Pattern pattern = Pattern.compile(regex);

            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                Matcher matcher = pattern.matcher(linha);
                if (matcher.find()) {
                    Requisicao novaRequisicao = new Requisicao();
                    novaRequisicao.enderecoIp = matcher.group(1);
                    novaRequisicao.identidadeCliente = matcher.group(2);
                    novaRequisicao.userId = matcher.group(3);
                    novaRequisicao.data = matcher.group(4);
                    novaRequisicao.tipoDeRequisicaoERecursoSolicitado = matcher.group(5);
                    novaRequisicao.codigoStatus = matcher.group(6);
                    novaRequisicao.tamanhoObjeto = matcher.group(7);
                    novaRequisicao.userAgent = matcher.group(9);  // O grupo 9 captura o user-agent

                    // Extraindo o sistema operacional do useragent
                    novaRequisicao.sistemaOperacional = novaRequisicao.extrairSistemaOperacional(novaRequisicao.userAgent);

                    listaRequisicao.add(novaRequisicao);

                    // Debug para garantir que está coletando corretamente
                    System.out.println(novaRequisicao.enderecoIp + " " + novaRequisicao.identidadeCliente + " " + novaRequisicao.userId + " " + novaRequisicao.data + " " + novaRequisicao.tipoDeRequisicaoERecursoSolicitado + " " + novaRequisicao.codigoStatus + " " + novaRequisicao.tamanhoObjeto + " " + novaRequisicao.sistemaOperacional);
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return listaRequisicao;
    }


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