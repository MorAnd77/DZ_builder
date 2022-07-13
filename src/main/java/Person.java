import java.util.OptionalInt;

public class Person {

    protected final String name;
    protected final String surname;
    protected Integer age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean hasAge() {
        return this.age != null;
    }

    public boolean hasAddress() {
        return this.address != null;
    }

    public void setAddress(String address) {
        if (!hasAddress())
            this.address = address;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(this.age);
    }

    public String getAddress() {
        return this.address;
    }


    public void happyBirthday() {
        if (hasAge())
            this.age += 1;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", age=" + getAge().getAsInt() +
                ", address='" + getAddress() + '\'' +
                '}';
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder childBuilder = new PersonBuilder();
        childBuilder.setSurname(getSurname());
        childBuilder.setAge(0);

        if (address != null) {
            childBuilder.setAddress(getAddress());
        }

        return childBuilder;
    }
}
