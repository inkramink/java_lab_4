import org.coll2.Department;
import org.coll2.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonTest {

    @Test
    public void testPersonGettersAndSetters() {
        Department department = new Department(1, "HR");
        Person person = new Person(1, "John Doe", "Male", department, 50000.0, "1985-01-01");

        assertEquals(1, person.getId());
        assertEquals("John Doe", person.getName());
        assertEquals("Male", person.getGender());
        assertEquals(department, person.getDepartment());
        assertEquals(50000.0, person.getSalary());
        assertEquals("1985-01-01", person.getBirthDate());

        person.setId(2);
        person.setName("Jane Doe");
        person.setGender("Female");
        person.setDepartment(new Department(2, "Engineering"));
        person.setSalary(60000.0);
        person.setBirthDate("1990-05-05");

        assertEquals(2, person.getId());
        assertEquals("Jane Doe", person.getName());
        assertEquals("Female", person.getGender());
        assertEquals(new Department(2, "Engineering"), person.getDepartment());
        assertEquals(60000.0, person.getSalary());
        assertEquals("1990-05-05", person.getBirthDate());
    }

    @Test
    public void testPersonEqualsAndHashCode() {
        Department department1 = new Department(1, "HR");
        Department department2 = new Department(1, "HR");
        Person person1 = new Person(1, "John Doe", "Male", department1, 50000.0, "1985-01-01");
        Person person2 = new Person(1, "John Doe", "Male", department2, 50000.0, "1985-01-01");

        assertEquals(person1, person2);
        assertEquals(person1.hashCode(), person2.hashCode());
    }
}