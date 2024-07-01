package br.com.java.mapper.custom;

import org.springframework.stereotype.Service;

import br.com.java.data.vo.v2.PersonVOV2;
import br.com.java.model.Person;

@Service
public class PersonMapper {

	public PersonVOV2 convertEntityToVO(Person person) {
		PersonVOV2 vo = new PersonVOV2();
		vo.setId(person.getId());
		vo.setAddress(person.getAddress());
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		vo.setGender(person.getGender());
		//vo.setBirthDay(new Date());
		return vo;
	}
	
	public Person convertVOToEntity(PersonVOV2 person) {
		Person entity = new Person();
		entity.setId(person.getId());
		entity.setAddress(person.getAddress());
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setGender(person.getGender());
		//vo.setBirthDay(new Date());
		return entity;
	}
}
