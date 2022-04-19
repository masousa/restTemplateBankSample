package br.com.letscode.eighteleven.samples.conta.payloads.clients;

import lombok.Data;

@Data
public class CPFInfo {
    private String nome;
    private  CPFStatus cpfStatus;
}
