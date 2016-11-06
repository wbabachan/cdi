package cdi.inject.person;

public class PersonServiceImpl<T extends Person> implements PersonService<T> {

    @Override
    public String getPersonStatus(T staff) {
        return staff.getName();
    }

}
