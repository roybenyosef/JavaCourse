package com.example.jpa.springjpa.db;

import javax.persistence.*;

@Entity
public class Person {
    private long id;
    private String name;
    private int age;
    private Gender gender;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    //@Enumerated(EnumType.STRING) //Keep as string in the database
    @Column
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
