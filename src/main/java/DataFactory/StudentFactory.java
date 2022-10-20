package DataFactory;

import Model.Student;
import com.github.javafaker.Faker;

public class StudentFactory {

    public Student getStudent() {
        return new Student.Builder()
                .name("Jan")
                .surname("Kowalski")
                .nationality("Equador")
                .age(22)
                .build();
    }

    public Student getRandomStudent() {
        Faker faker = new Faker();
        return new Student.Builder()
                .name(faker.name().firstName())
                .surname(faker.name().lastName())
                .nationality(faker.country().name())
                .age(faker.number().numberBetween(18, 99))
                .build();
    }
}
