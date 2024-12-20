package com.example.KafkaProducerJira.api.controller;

import com.example.KafkaProducerJira.configuration.KafkaConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/api/v1.0"})
@RequiredArgsConstructor
public class postKafka {
        private final KafkaConfig kafkaConfig;
        private final KafkaTemplate<String, String> kafkaTemplate;

        @PostMapping(value = "/postTask")
        public void postMessage(@RequestBody String message) {
                kafkaTemplate.send("post_task", message);
        }
}
