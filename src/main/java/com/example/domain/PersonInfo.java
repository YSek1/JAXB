package com.example.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="personInfo")
public class PersonInfo {

	private String name;
	private String age;

	public String getName() {
		return name;
	}
	@XmlElement(namespace="name")
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	@XmlElement(namespace="age")
	public void setAge(String age) {
		this.age = age;
	}
}