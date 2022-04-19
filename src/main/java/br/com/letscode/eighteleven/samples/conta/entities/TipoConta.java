package br.com.letscode.eighteleven.samples.conta.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum TipoConta {
    POUPANCA("Poupança"),CONTA_CORRENTE("Conta Corrente");
    private String label;
}
