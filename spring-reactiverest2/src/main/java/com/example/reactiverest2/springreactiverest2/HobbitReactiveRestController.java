package com.example.reactiverest2.springreactiverest2;

import com.example.reactiverest2.springreactiverest2.beans.Line;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class HobbitReactiveRestController {

    @Autowired
    private HobbitFlux hobbit;

    @GetMapping(value = "vod/{from}/{to}/{delay}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Line> readHobbit(@PathVariable int from, @PathVariable int to, @PathVariable int delay) {
        return hobbit.getHobbitVod()
                .skipWhile(line -> line.getIndex() < from)
                .takeUntil(line -> line.getIndex() > to - 1)
                .delayElements(Duration.ofSeconds(delay));
    }

    @GetMapping(value = "join", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Line> join() {
        return hobbit.getHobbitLive();
    }
}
