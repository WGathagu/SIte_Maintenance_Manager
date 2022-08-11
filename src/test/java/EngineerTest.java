import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EngineerTest {

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void person_instantiatesCorrectly_true() {
        Engineer testEngineer = new Engineer("Peter Wangari", "[email protected]");
        assertEquals(true, testEngineer instanceof Engineer);
    }

    @Test
    public void getName_personInstantiatesWithName_Henry() {
        Engineer testEngineer = new Engineer("Peter Wangari", "[email protected]");
        assertEquals("Peter Wangari", testEngineer.getName());
    }

    @Test
    public void getEmail_personInstantiatesWithEmail_String() {
        Engineer testEngineer = new Engineer("Peter Wangari", "[email protected]");
        assertEquals("[email protected]", testEngineer.getEmail());
    }

    @Test
    public void equals_returnsTrueIfNameAndEmailAreSame_true() {
        Engineer firstEngineer = new Engineer("Peter Wangari", "[email protected]");
        Engineer anotherEngineer = new Engineer("Fiona Wangui", "[email protected]");
        assertTrue(firstEngineer.equals(anotherEngineer));
    }
    @Test
    public void save_insertsObjectIntoDatabase_Person() {
        Engineer testEngineer = new Engineer("Peter Wangari", "[email protected]");
        testEngineer.save();
        assertTrue(Engineer.all().get(0).equals(testEngineer));
    }
}

