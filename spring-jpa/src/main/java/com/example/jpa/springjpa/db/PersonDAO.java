package com.example.jpa.springjpa.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public class PersonDAO {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public long addPerson(Person person) {
        entityManager.persist(person);
        return person.getId();
    }

    @Transactional
    public Person getPerson(long id) {
        return entityManager.find(Person.class, id);
    }

    @Transactional
    public long addForum(Forum forum)
    {
        entityManager.persist(forum);
        return forum.getId();
    }
}
