package com.sophossolutions.modulo2.services;

import com.sophossolutions.modulo2.models.Band;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class KafkaBootProducerService {

    private String topico;
    private Band band;
}
