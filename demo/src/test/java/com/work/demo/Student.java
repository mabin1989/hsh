package com.work.demo;

public class Student {
private String name;
private int sex;
public String getName() {
	return name;
}
public Student(String name, int sex) {
	super();
	this.name = name;
	this.sex = sex;
}
public void setName(String name) {
	this.name = name;
}
public int getSex() {
	return sex;
}
public void setSex(int sex) {
	this.sex = sex;
}

}
