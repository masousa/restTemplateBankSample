package br.com.letscode.eighteleven.samples.conta.controllers;

import br.com.letscode.eighteleven.samples.conta.payloads.ContaPayloadResponse;
import br.com.letscode.eighteleven.samples.conta.payloads.ContaRequest;
import br.com.letscode.eighteleven.samples.conta.services.CreateAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/conta")
@RequiredArgsConstructor
public class ContaExemploController {

    private final CreateAccountService createAccountService;

    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ContaPayloadResponse createAccount(@RequestBody ContaRequest contaRequest){
        return createAccountService.execute(contaRequest);
    }
}
