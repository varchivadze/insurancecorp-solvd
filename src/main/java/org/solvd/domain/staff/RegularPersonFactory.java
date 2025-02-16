package org.solvd.domain.staff;

public class RegularPersonFactory implements AbstractFactory<CallablePerson>{
    @Override
    public CallablePerson create(Type type) {
        CallablePerson callablePerson = null;
        switch (type) {
            case PERSON -> callablePerson = new Client();
            default -> {
                return callablePerson;
            }
        }
        return callablePerson;
    }
}

