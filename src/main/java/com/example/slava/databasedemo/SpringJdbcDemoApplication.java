package com.example.slava.databasedemo;

import com.example.slava.databasedemo.entity.Person;
import com.example.slava.databasedemo.jdbc.PersonJdbcDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

// @SpringBootApplication
public class SpringJdbcDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	PersonJdbcDao dao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users -> {}", dao.findAll());
		logger.info("User id 10001 -> {}", dao.findById(10001));
		logger.info("User id James -> {}", dao.findByName("James"));
		logger.info("Deleting 10002 -> No on Rows deleted = {}",
				dao.deleteById(10002));
		logger.info("Inserting 10004 -> {}",
				dao.insert(new Person(10004, "Tara", "Berlin", new Date())));
		logger.info("Updating 10003 -> {}",
				dao.update(new Person(10003, "Pieter", "Utrecht", new Date())));
	}
}
