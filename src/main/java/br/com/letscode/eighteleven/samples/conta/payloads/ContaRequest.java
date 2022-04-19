package br.com.letscode.eighteleven.samples.conta.payloads;

import br.com.letscode.eighteleven.samples.conta.entities.TipoConta;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ContaRequest {
    private String cpf;
    private String nome;
    private String senha;
    private String agencia;
    @JsonProperty("tipo-conta")
    private TipoConta tipoConta;

}
