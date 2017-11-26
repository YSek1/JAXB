package com.example.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="person")
public class Person {

	private PersonInfo personInfo;

	public PersonInfo getPersonInfo() {
		return personInfo;
	}
	@XmlElement(namespace="personInfo")
	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}
}
