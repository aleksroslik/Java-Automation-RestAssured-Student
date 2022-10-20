package Model;

public class Student {

    private String name;
    private String surname;
    private String nationality;
    private int age;

    public Student(String name, String surname, String nationality, int age) {
        this.name = name;
        this.surname = surname;
        this.nationality = nationality;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getNationality() {
        return nationality;
    }

    public int getAge() {
        return age;
    }

    public Student(final Builder builder) {
        this.name = builder.name;
        this.surname = builder.surname;
        this.nationality = builder.nationality;
        this.age = builder.age;
    }

    public static class Builder {
        private String name;
        private String surname;
        private String nationality;
        private int age;

        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        public Builder surname(final String surname) {
            this.surname = surname;
            return this;
        }

        public Builder nationality(final String nationality) {
            this.nationality = nationality;
            return this;
        }

        public Builder age(final int age) {
            this.age = age;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
