package filter;

import java.util.ArrayList;
import java.util.List;

public class CriteriaPattern {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        persons.add(new Person("Robert","male", "Single"));
        persons.add(new Person("John", "male", "Married"));
        persons.add(new Person("Laura", "female", "Married"));
        persons.add(new Person("Diana", "female", "Single"));
        persons.add(new Person("Mike", "male", "Single"));
        persons.add(new Person("Bobby", "male", "Single"));

        Criteria male = new CriteriaMale();
        Criteria female = new CriteriaFemale();
        Criteria single = new CriteriaSingle();

        Criteria singleMale = new CriteriaAnd(single, male);
        Criteria singleOrFemale = new CriteriaOr(single, female);

        System.out.println("Males: ");
        printPersons(male.meetCriteria(persons));

        System.out.println("\nFemales: ");
        printPersons(female.meetCriteria(persons));

        System.out.println("\nSingle Males: ");
        printPersons(singleMale.meetCriteria(persons));

        System.out.println("\nSingle Or Females: ");
        printPersons(singleOrFemale.meetCriteria(persons));
    }

    public static void printPersons(List<Person> persons){

        for (Person person : persons) {
            System.out.println("Person : [ Name : " + person.getName() + ", Gender : " + person.getGender() + ", Marital Status : " + person.getMaritalStatus() + " ]");
        }
    }
}
