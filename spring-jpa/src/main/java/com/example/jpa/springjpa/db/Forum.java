package com.example.jpa.springjpa.db;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Forum {
    private long id;
    private String name;
    private Set<Person> members;

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    public Set<Person> getMembers() {
        return members;
    }

    public void setMembers(Set<Person> members) {
        this.members = members;
    }
}
