package br.com.letscode.eighteleven.samples.conta.jms.serializer;

import br.com.letscode.eighteleven.samples.conta.payloads.jms.Account;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Objects;

@Slf4j
public class AccountSerializer implements Serializer<Account> {
    private final ObjectMapper mapper = new ObjectMapper();
    @Override
    public byte[] serialize(String s, Account account) {
        try {
            if(Objects.nonNull(account)){

                    return mapper.writeValueAsBytes(account);

            }
        } catch (JsonProcessingException e) {
            log.error("Json processing error account serializer", e);
            throw new RuntimeException(e);
        }
        return null;
    }
}
