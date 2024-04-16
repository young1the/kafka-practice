package org.example.kafkaproducer.rest;

import lombok.RequiredArgsConstructor;
import org.example.kafkaproducer.stream.WikimediaStreamConsumer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/wikimedia")
@RequiredArgsConstructor
public class WikimediaController {
    private final WikimediaStreamConsumer wikimediaStreamConsumer;

    @RequestMapping("/start")
    public void startPublishing() {
        wikimediaStreamConsumer.consumeStreamAndPublish();
    }

//    @RequestMapping("/stop")
//    public void stop() {
//        wikimediaStreamConsumer.stopStream();
//    }
}
