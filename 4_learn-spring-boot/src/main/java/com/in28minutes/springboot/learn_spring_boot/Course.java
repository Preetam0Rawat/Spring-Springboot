package com.in28minutes.springboot.learn_spring_boot;

public class Course {
 private long id;
 private String name;
 private String auhor;



 //Constructor
 
 public Course(long id, String name, String auhor) {
	super();
	this.id = id;
	this.name = name;
	this.auhor = auhor;
}

 
 //Getter
 public long getId() {
	return id;
 }


 public String getName() {
	return name;
 }


 public String getAuhor() {
	return auhor;
 }
 
 
 //toString
 @Override
 public String toString() {
	return "Courses [id=" + id + ", name=" + name + ", auhor=" + auhor + "]";
 }



}
