package com.example.jpa.springjpa.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface PersonRepository extends JpaRepository<Person, Long> {
    //you get all of this from spring (use ctrl+f12 to see everything you get)
    Set<Person> findByAgeBerween(int age, int highAge); //this is automatically generated!

    //if we want to call queries directly , using JPQL
    @Query("SELECT p FROM Forum as f JOIN f.members as p")
    Set<Person> findMembers();
}
