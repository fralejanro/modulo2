package com.sophossolutions.modulo2.services;

import com.sophossolutions.modulo2.util.KafkaConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
public class KafkaConsumerService {
    private final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumerService.class);

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaConsumerService(KafkaTemplate<String,String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public String getLastBand(String topico){
        ConsumerRecord<String,String> lastBand;
        KafkaConfig kafkaConfig = new KafkaConfig();
        kafkaTemplate.setConsumerFactory(kafkaConfig.consumerFactory());
        lastBand =  kafkaTemplate.receive(topico,0,2);
        String band = (String) Objects.requireNonNull(lastBand.value());
        //LOGGER.info("Ultima banda: "+ Objects.requireNonNull(band.getName()));
        return band;
    }
}
