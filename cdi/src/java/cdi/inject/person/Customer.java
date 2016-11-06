package cdi.inject.person;

public class Customer implements Person {

    @Override
    public String getName() {
        return "This is the name of Customer !";
    }

}
