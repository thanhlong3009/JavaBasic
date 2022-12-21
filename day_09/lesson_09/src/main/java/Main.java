import com.github.javafaker.Faker;

public class Main {
    public static void main(String[] args) {

        //Casch 1 : Su dung constructor
        Person person = new Person(1, "Long", "long@gmail.com");
        System.out.println(person);
        // Cach 2: Su dung builder
        Person person1 = Person.builder()
                .email("a@gmail.com")
                .name("Sơn")
                .build();
        System.out.println(person1);

        // tạo ra nhiều đối tượng Person
        Faker faker = new Faker();
        Person[] people = new Person[1];
        for (int i = 0; i < people.length; i++) {
            people[i] = new Person(i+1,faker.name().fullName(),faker.internet().emailAddress());
        }

        for (Person p: people) {
            System.out.println(p);
        }

        System.out.println(faker.leagueOfLegends().champion());


    }
}
