package br.com.letscode.eighteleven.samples.conta.payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ContaPayloadResponse extends ContaRequest{

    @JsonProperty("numero")
    private String numeroConta;

    public static ContaPayloadResponse fromRequest(ContaRequest contaRequest, String numeroConta) {
        ContaPayloadResponse response = new ContaPayloadResponse();
        response.setNumeroConta(numeroConta);
        response.setAgencia(contaRequest.getAgencia());
        response.setCpf(contaRequest.getCpf());
        response.setNome(contaRequest.getNome());
        return response;
    }
}
