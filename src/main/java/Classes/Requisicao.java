package Classes;

public class Requisicao {
    public String enderecoIp;
    public String identidadeCliente;
    public String userId;
    public String data;
    public String tipoDeRequisicaoERecursoSolicitado;
    public String codigoStatus;
    public String tamanhoObjeto;

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
