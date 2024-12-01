import org.coll2.Department;
import org.coll2.Person;
import org.coll2.CSVReaderC;
import org.coll2.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CSVReaderCTest {

    @Test
    public void testReadCSV() {
        CSVReaderC csvReaderC = new CSVReaderC();
        List<Person> people = csvReaderC.readCSV("testfile.csv");

        assertNotNull(people);
        assertEquals(2, people.size());

        Person person1 = people.get(0);
        assertEquals(1, person1.getId());
        assertEquals("John Doe", person1.getName());
        assertEquals("Male", person1.getGender());
        assertEquals(new Department(1, "HR"), person1.getDepartment());
        assertEquals(50000.0, person1.getSalary());
        assertEquals("1985-01-01", person1.getBirthDate());

        Person person2 = people.get(1);
        assertEquals(2, person2.getId());
        assertEquals("Jane Doe", person2.getName());
        assertEquals("Female", person2.getGender());
        assertEquals(new Department(2, "Engineering"), person2.getDepartment());
        assertEquals(60000.0, person2.getSalary());
        assertEquals("1990-05-05", person2.getBirthDate());
    }
}