package br.com.letscode.eighteleven.samples.conta.services;

import br.com.letscode.eighteleven.samples.conta.clients.GetCPFInfoClient;
import br.com.letscode.eighteleven.samples.conta.entities.Cliente;
import br.com.letscode.eighteleven.samples.conta.entities.Conta;
import br.com.letscode.eighteleven.samples.conta.jms.producer.CreateAccountProducer;
import br.com.letscode.eighteleven.samples.conta.payloads.ContaPayloadResponse;
import br.com.letscode.eighteleven.samples.conta.payloads.ContaRequest;
import br.com.letscode.eighteleven.samples.conta.payloads.clients.CPFInfo;
import br.com.letscode.eighteleven.samples.conta.payloads.clients.CPFStatus;
import br.com.letscode.eighteleven.samples.conta.payloads.jms.Account;
import br.com.letscode.eighteleven.samples.conta.repositories.ClienteRepository;
import br.com.letscode.eighteleven.samples.conta.repositories.ContaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class CreateAccountService {
    private final ContaRepository contaRepository;
    private final ClienteRepository clienteRepository;

    private final GetCPFInfoClient getCPFInfoClient;

    private final CreateAccountProducer createAccountProducer;
    public ContaPayloadResponse execute(ContaRequest contaRequest) {
        Conta conta = new Conta();
        conta.setTipoConta(contaRequest.getTipoConta());
        conta.setAgencia(conta.getAgencia());
        Cliente cliente = new Cliente();
        cliente.setCpf(contaRequest.getCpf());
        cliente.setNome(contaRequest.getNome());
        conta.setCliente(cliente);

        //TODO validar cliente
        final CPFInfo cpfInfo = getCPFInfoClient.execute(contaRequest.getCpf());
        if(cpfInfo.getCpfStatus().equals(CPFStatus.DISPONIVEL)){
            //TODO gerar numero conta
            conta.setNumeroConta(""+new Random(99999).nextInt());

            clienteRepository.save(cliente);
            contaRepository.save(conta);

            return ContaPayloadResponse.fromRequest(contaRequest, conta.getNumeroConta());
        } else if (cpfInfo.getCpfStatus().equals(CPFStatus.NAOCADASTRADO)) {

            Account account = new Account();
            account.setCpf(contaRequest.getCpf());
            account.setNome(contaRequest.getNome());
            createAccountProducer.send(account);

        }


        return null;
    }
}
