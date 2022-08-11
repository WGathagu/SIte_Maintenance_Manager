import org.junit.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmployeeTest {

    @Test
    public void person_instantiatesCorrectly_true() {
        Employee testPerson = new Employee("Peter Wangari", "[email protected]");
        assertEquals(true, testPerson instanceof Employee);
    }

    @Test
    public void getName_personInstantiatesWithName_Henry() {
        Employee testPerson = new Employee("Peter Wangari", "[email protected]");
        assertEquals("Peter Wangari", testPerson.getName());
    }

    @Test
    public void getEmail_personInstantiatesWithEmail_String() {
        Employee testPerson = new Employee("Peter Wangari", "[email protected]");
        assertEquals("[email protected]", testPerson.getEmail());
    }

    @Test
    public void equals_returnsTrueIfNameAndEmailAreSame_true() {
        Employee firstPerson = new Employee("Peter Wangari", "[email protected]");
        Employee anotherPerson = new Employee("Peter Wangari", "[email protected]");
        assertTrue(firstPerson.equals(anotherPerson));
    }
    @Test
    public void save_insertsObjectIntoDatabase_Person() {
        Employee testEmployee = new Employee("Henry", "[email protected]");
        testEmployee.save();
        assertTrue(Employee.all().get(0).equals(testEmployee));
    }
}

