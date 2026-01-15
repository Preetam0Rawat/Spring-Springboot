package com.in28minutes.springboot.learn_jpa_and_hibernate.course;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity                      //can also give name here(name of the table in DB)
public class Course {

	@Id
	private long id;
	
	@Column(name="name")        //can be removed as name are same here and in table
	private String name;

	@Column(name="author")
    private String author;
	
	public Course() {
		
	}
	
	public Course(long id, String name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}
	
		
	
	
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return author;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
	}
