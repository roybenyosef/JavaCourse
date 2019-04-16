package com.example.jpa.springjpa;

import com.example.jpa.springjpa.beans.A;
import com.example.jpa.springjpa.db.Forum;
import com.example.jpa.springjpa.db.Gender;
import com.example.jpa.springjpa.db.Person;
import com.example.jpa.springjpa.db.PersonDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(SpringJpaApplication.class, args);
		//A a = run.getBean("a");
		PersonDAO personDAO = (PersonDAO)run.getBean("personDAO");
		Person p1 = new Person();
		p1.setAge(5);
		p1.setGender(Gender.Male);
		p1.setName("Moshe");

		System.out.println("Added person:" + personDAO.addPerson(p1));

		Person getPerson = personDAO.getPerson(1);
		System.out.println(getPerson.getName());

		Person p2 = new Person();
		p2.setAge(52);
		p2.setGender(Gender.Male);
		p2.setName("Moshe2");

		Person p3 = new Person();
		p3.setAge(52);
		p3.setGender(Gender.Male);
		p3.setName("Moshe2");

		Forum f = new Forum();
		f.setName("Yoyoma forum");
		Set<Person> members = new HashSet<>();
		members.add(p2);
		members.add(p3);
		f.setMembers(members);
		personDAO.addForum(f);

		//Instead of the DAO, you can use the repository

	}

}
