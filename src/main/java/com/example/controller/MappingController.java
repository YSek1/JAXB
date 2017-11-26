package com.example.controller;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Person;
import com.example.domain.PersonInfo;

@RestController
@RequestMapping("jaxb")
public class MappingController {

	@RequestMapping(value="/hello")
	private String hello() {
		return ("Hello");
	}

	@RequestMapping(value="/marshal")
	private void installInfo() {

		PersonInfo personInfo = new PersonInfo();
		personInfo.setName("seki");
		personInfo.setAge("25");

		try {
			File file = new File("C://pleiades/workspace/jaxb/src/main/resources/personInfoTest.xml");

			JAXBContext jaxbContext = JAXBContext.newInstance(PersonInfo.class);
			Marshaller jaxbMashaler = jaxbContext.createMarshaller();

			jaxbMashaler.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMashaler.marshal(personInfo, file);

		} catch(JAXBException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value="/marshal2")
	private void installInfo2() {

		PersonInfo personInfo = new PersonInfo();
		personInfo.setName("seki");
		personInfo.setAge("25");

		Person person = new Person();
		person.setPersonInfo(personInfo);

		try {
			File file = new File("C://pleiades/workspace/jaxb/src/main/resources/personInfo.xml");

			JAXBContext jaxbContext = JAXBContext.newInstance(Person.class);
			Marshaller jaxbMashaler = jaxbContext.createMarshaller();

			jaxbMashaler.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			jaxbMashaler.marshal(person, file);

		} catch(JAXBException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value="/unmarshal")
	private void displayInfo() {

		try {
			File file = new File("C://pleiades/workspace/jaxb/src/main/resources/personInfoTest.xml");

			JAXBContext jaxbContext = JAXBContext.newInstance(PersonInfo.class);
			Unmarshaller jaxbUnmarshall = jaxbContext.createUnmarshaller();

			PersonInfo personInfo = (PersonInfo) jaxbUnmarshall.unmarshal(file);
			System.out.println(personInfo.getName());
			System.out.println(personInfo.getAge());

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value="/unmarshal2")
	private void displayInfo2() {

		try {
			File file = new File("C://pleiades/workspace/jaxb/src/main/resources/personInfo.xml");

			JAXBContext jaxbContext = JAXBContext.newInstance(PersonInfo.class);
			Unmarshaller jaxbUnmarshall = jaxbContext.createUnmarshaller();

			PersonInfo personInfo = (PersonInfo) jaxbUnmarshall.unmarshal(file);
			System.out.println(personInfo.getName());
			System.out.println(personInfo.getAge());

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}