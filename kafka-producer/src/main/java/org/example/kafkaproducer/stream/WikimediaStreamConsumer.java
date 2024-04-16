package org.example.kafkaproducer.stream;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.kafkaproducer.producer.WikimediaProducer;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
@Slf4j
public class WikimediaStreamConsumer {

    private final WebClient webClient;
    private final WikimediaProducer wikimediaProducer;

    public void consumeStreamAndPublish() {
        webClient.get().uri("/stream/recentchange").retrieve()
                .bodyToFlux(String.class)
                .subscribe(wikimediaProducer::sendMessage);
    }

}
