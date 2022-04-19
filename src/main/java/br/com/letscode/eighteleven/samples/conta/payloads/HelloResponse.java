package br.com.letscode.eighteleven.samples.conta.payloads;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class HelloResponse {
    private String text;
}
