package org.solvd.domain.staff;

public class FactoryProvider {

    public static AbstractFactory<CallablePerson> getFactory(String type) {
        AbstractFactory<CallablePerson> factory = null;
        switch (type) {
            case "business" -> factory = new BusinessPersonFactory();
            default -> factory = new RegularPersonFactory();
        }
        return factory;
    }
}
