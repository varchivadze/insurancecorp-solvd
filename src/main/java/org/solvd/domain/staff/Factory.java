package org.solvd.domain.staff;

public class Factory {

    public static CallablePerson createPerson(String type) {
        return switch (type) {
            case "employee" -> new Employee();
            case "client" -> new Client();
            default -> new Person();
        };
    }
}
