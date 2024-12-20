package com.example.KafkaProducerJira.configuration;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.serialization.ShortDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.*;

@EnableKafka
@Configuration
@RequiredArgsConstructor
public class KafkaConfig {
    private final KafkaProperties kafkaConfig;

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        ProducerFactory<String, String> producerFactory = new DefaultKafkaProducerFactory<>(
                kafkaConfig.buildProducerProperties(),
                new StringSerializer(),
                new StringSerializer()
        );
        return new KafkaTemplate(producerFactory);
    }

    @Bean
    public DefaultKafkaConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory(
                kafkaConfig.buildConsumerProperties(),
                new ShortDeserializer(),
                new ShortDeserializer()
        );
    }
}
