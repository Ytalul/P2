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
    public String urlReferencia;


    protected String extrairSistemaOperacional(String userAgent) {
        this.sistemaOperacional = "Desconhecido";
        if (userAgent.contains("Windows")) {
            sistemaOperacional = "Windows";
        } else if (userAgent.contains("Macintosh")) {
            sistemaOperacional = "Macintosh";
        } else if (userAgent.contains("Ubuntu")) {
            sistemaOperacional = "Ubuntu";
        } else if (userAgent.contains("Fedora")) {
            sistemaOperacional = "Fedora";
        } else if (userAgent.contains("Mobile")||userAgent.contains("Android")) {
            sistemaOperacional = "Mobile";
        } else if (userAgent.contains("Linux")||userAgent.contains("X11")) {
            sistemaOperacional = "Linux";
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
