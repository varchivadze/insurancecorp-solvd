package org.solvd.domain.staff;

public class BusinessPersonFactory implements AbstractFactory<CallablePerson> {

    @Override
    public CallablePerson create(Type type) {
        CallablePerson callablePerson = null;
        switch (type) {
            case CLIENT -> callablePerson = new Client();
            case EMPLOYEE -> callablePerson = new Employee();
        }
        return callablePerson;
    }
}
