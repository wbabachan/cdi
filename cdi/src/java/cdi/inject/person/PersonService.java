package cdi.inject.person;

public interface PersonService<T extends Person> {

    String getPersonStatus(T staff);
}
