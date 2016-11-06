package cdi.inject.person;

public class User implements Person {

    @Override
    public String getName() {
        return "This is the name of User !";
    }

}
