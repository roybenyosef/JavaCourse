package com.example.reactiverest2.springreactiverest2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import com.example.reactiverest2.springreactiverest2.beans.Line;
import org.springframework.stereotype.Component;

import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

@Component
public class HobbitFlux {

    private Flux<Line> hobbitVod;

    public Flux<Line> getHobbitVod() {
        return hobbitVod;
    }

    public ConnectableFlux<Line> getHobbitLive() {
        return hobbitLive;
    }

    private ConnectableFlux<Line> hobbitLive;

    public HobbitFlux() throws Exception {
        List<String> data = Files.readAllLines(Paths.get(getClass().getClassLoader().getResource("Hobbit.txt").toURI()));
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            Line l = new Line();
            l.setIndex(i+1);
            l.setContent(data.get(i));
            lines.add(l);
        }

        hobbitVod = Flux.fromIterable(lines);
        hobbitLive = hobbitVod.delayElements(Duration.ofSeconds(2)).replay(3);
        hobbitLive.connect();

    }

}