package Classes;

public class Requisicao {
    public String enderecoIp;
    public String identidadeCliente;
    public String userId;
    public String data;
    public String tipoDeRequisicaoERecursoSolicitado;
    public String codigoStatus;
    public String tamanhoObjeto;
    public String userAgent;
    public String sistemaOperacional;


    protected String extrairSistemaOperacional(String userAgent) {
        this.sistemaOperacional = "Desconhecido";
        if (userAgent.contains("Windows NT")) {
            sistemaOperacional = "Windows";
        } else if (userAgent.contains("Mac OS X")) {
            sistemaOperacional = "Mac OS X";
        } else if (userAgent.contains("Linux")) {
            sistemaOperacional = "Linux";
        } else if (userAgent.contains("Android")) {
            sistemaOperacional = "Android";
        } else if (userAgent.contains("iPhone")) {
            sistemaOperacional = "iOS";
        }

        return sistemaOperacional;
    }

    @Override
    public String toString() {
        return "Requisicao{" +
                "enderecoIp='" + enderecoIp + '\'' +
                ", identidadeCliente='" + identidadeCliente + '\'' +
                ", userId='" + userId + '\'' +
                ", data='" + data + '\'' +
                ", tipoDeRequisicaoERecursoSolicitado='" + tipoDeRequisicaoERecursoSolicitado + '\'' +
                ", codigoStatus='" + codigoStatus + '\'' +
                ", tamanhoObjeto='" + tamanhoObjeto + '\'' +
                '}';
    }
}
