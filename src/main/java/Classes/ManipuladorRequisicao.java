package Classes;
import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ManipuladorRequisicao {

    public ArrayList<Requisicao> criarListaRequisicao() throws IOException {
        ArrayList<Requisicao> listaRequisicao = new ArrayList<Requisicao>();

        try {
            File arquivo = new File("C:\\Users\\14040160401\\Downloads\\access.log");
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
                    novaRequisicao.urlReferencia = matcher.group(8);
                    novaRequisicao.userAgent = matcher.group(9);  // O grupo 9 captura o user-agent

                    // Extraindo o sistema operacional do useragent
                    novaRequisicao.sistemaOperacional = novaRequisicao.extrairSistemaOperacional(novaRequisicao.userAgent);

                    listaRequisicao.add(novaRequisicao);

                    // Debug para garantir que está coletando corretamente
                    System.out.println(novaRequisicao.enderecoIp + " " + novaRequisicao.identidadeCliente + " " + novaRequisicao.userId + " " + novaRequisicao.data + " " + novaRequisicao.tipoDeRequisicaoERecursoSolicitado + " " + novaRequisicao.codigoStatus + " " + novaRequisicao.tamanhoObjeto + " " + novaRequisicao.sistemaOperacional + " " + novaRequisicao.urlReferencia);
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return listaRequisicao;
    }

}