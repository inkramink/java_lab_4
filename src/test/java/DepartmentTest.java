import org.coll2.Department;
import org.coll2.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DepartmentTest {

    @Test
    public void testDepartmentGettersAndSetters() {
        Department department = new Department(1, "HR");

        assertEquals(1, department.getId());
        assertEquals("HR", department.getName());

        department.setId(2);
        department.setName("Engineering");

        assertEquals(2, department.getId());
        assertEquals("Engineering", department.getName());
    }

    @Test
    public void testDepartmentEqualsAndHashCode() {
        Department department1 = new Department(1, "HR");
        Department department2 = new Department(1, "HR");

        assertEquals(department1, department2);
        assertEquals(department1.hashCode(), department2.hashCode());
    }
}