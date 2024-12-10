package com.confluent.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.confluent.jsondto.Employee;

@Service
@Slf4j
public class KafkaJsonConsumer {

    @KafkaListener(id = "myConsumer", topics = "employee_data_json", groupId = "springboot-group-1", autoStartup = "true")
    public void read(ConsumerRecord<String, Employee> consumerRecord) {
        String key = consumerRecord.key();
        Object employee = consumerRecord.value();
        log.info("Json message received for key : " + key + " value : " + employee.toString());

    }
}
