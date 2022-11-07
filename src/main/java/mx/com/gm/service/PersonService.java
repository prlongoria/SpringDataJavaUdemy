package mx.com.gm.service;

import mx.com.gm.domain.Person;

import java.util.List;

public interface PersonService {
    public List<Person> readPersons();
    public void save(Person person);
    public void delete (Person person);
    public Person findPerson(Person person);

}
