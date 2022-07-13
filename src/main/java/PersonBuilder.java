public class PersonBuilder {

    protected String name;
    protected String surname;
    protected int age;
    protected String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalStateException("Возраст недопустимый");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null || surname == null) {
            throw new IllegalStateException("Не хватает обязательных полей");
        } else {
            if (age < 0 && address == null) {
                return new Person(name, surname);
            } else if (age < 0 && address != null) {
                Person person = new Person(name, surname);
                person.setAddress(address);
                return person;
            } else if (age >= 0 && address != null) {
                Person person = new Person(name, surname, age);
                person.setAddress(address);
                return person;
            } else if (age >= 0 && address == null) {
                return new Person(name, surname, age);
            }
        }
        return null;
    }
}