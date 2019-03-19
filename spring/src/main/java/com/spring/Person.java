package com.spring;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor - can't do it with spring, it needs to know what to put there
@NoArgsConstructor
@Data
@ToString(of={"name"}) //@ToString(of={"name", "age"}) //but @Data include the default
public class Person {
    @NonNull private String name = "moshe";
    private int age;
}
