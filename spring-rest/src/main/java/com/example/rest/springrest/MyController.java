package com.example.rest.springrest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {

    @GetMapping("sum/{num1}/{num2}")
    public int sum(@PathVariable("num1") int x, @PathVariable("num2") int y) {
        return x + y;
    }

    @GetMapping("greet")
    public String greet(@RequestParam(value="user", defaultValue = "NoName") String name){
        return "Hello " + name;
    }

    @GetMapping("getAll")
    public List<Person> getAll() {
        List<Person> list = new ArrayList<>();
        list.add(Person.builder().id(1).age(10).name("yoyoma").build());
        list.add(Person.builder().id(2).age(42).name("moshe").build());

        return list;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> update(@PathParam("id") int id,
                                         @RequestBody Person p) {
        if (id == 1 ) {
            return ResponseEntity.notFound().build();
        }
        p.setName(p.getName() + " handled by server");
        return ResponseEntity.ok(p);
    }

    @PostMapping
    public ResponseEntity<Person> add(@RequestBody Person p) {
        if (p.getAge() < 0 || p.getAge() > 120) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(p);
    }

}
