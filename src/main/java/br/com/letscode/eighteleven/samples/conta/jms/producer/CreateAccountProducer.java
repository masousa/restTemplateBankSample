package br.com.letscode.eighteleven.samples.conta.jms.producer;

import br.com.letscode.eighteleven.samples.conta.payloads.jms.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateAccountProducer {

    @Value("${kafka.topic.name}")
    private String topicName;
    private final KafkaTemplate<String, Account> kafkaTemplate;

    public void send(Account account){
        kafkaTemplate.send(topicName,account);
    }
}
