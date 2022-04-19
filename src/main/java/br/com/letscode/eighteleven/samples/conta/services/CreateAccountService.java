package br.com.letscode.eighteleven.samples.conta.services;

import br.com.letscode.eighteleven.samples.conta.clients.GetCPFInfoClient;
import br.com.letscode.eighteleven.samples.conta.entities.Cliente;
import br.com.letscode.eighteleven.samples.conta.entities.Conta;
import br.com.letscode.eighteleven.samples.conta.payloads.ContaPayloadResponse;
import br.com.letscode.eighteleven.samples.conta.payloads.ContaRequest;
import br.com.letscode.eighteleven.samples.conta.payloads.clients.CPFStatus;
import br.com.letscode.eighteleven.samples.conta.repositories.ClienteRepository;
import br.com.letscode.eighteleven.samples.conta.repositories.ContaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateAccountService {
    private final ContaRepository contaRepository;
    private final ClienteRepository clienteRepository;

    private final GetCPFInfoClient getCPFInfoClient;
    public ContaPayloadResponse execute(ContaRequest contaRequest) {
        Conta conta = new Conta();
        conta.setTipoConta(contaRequest.getTipoConta());
        conta.setAgencia(conta.getAgencia());
        Cliente cliente = new Cliente();
        cliente.setCpf(contaRequest.getCpf());
        cliente.setNome(contaRequest.getNome());
        conta.setCliente(cliente);

        //TODO validar cliente
        if(getCPFInfoClient.execute(contaRequest.getCpf()).getCpfStatus().equals(CPFStatus.DISPONIVEL)){
            //TODO gerar numero conta
            conta.setNumeroConta(""+new Random(99999).nextInt());

            clienteRepository.save(cliente);
            contaRepository.save(conta);

            return ContaPayloadResponse.fromRequest(contaRequest, conta.getNumeroConta());
        }


        return null;
    }
}
