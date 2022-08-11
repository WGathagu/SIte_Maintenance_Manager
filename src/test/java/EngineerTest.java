import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.*;

import java.util.Date;

public class EngineerTest {

    //@Rule
    //public DatabaseRule database = new DatabaseRule();

    Date date = new Date();

    @Test
    public void Engineer_instantiatesCorrectly_true() {

        Engineer testEngineer = new Engineer("Peter Wangari", "[email protected]", "Tokyo", date);
        assertEquals(true, testEngineer instanceof Engineer);
    }

    @Test
    public void getName_EngineerInstantiatesWithName_Henry() {
        Engineer testEngineer = new Engineer("Peter Wangari", "[email protected]", "Tokyo", date);
        assertEquals("Peter Wangari", testEngineer.getName());
    }

    @Test
    public void getEmail_EngineerInstantiatesWithEmail_String() {
        Engineer testEngineer = new Engineer("Peter Wangari", "[email protected]", "Tokyo", date);
        assertEquals("[email protected]", testEngineer.getEmail());
    }

    @Test
    public void equals_returnsTrueIfNameAndEmailAreSame_true() {
        Engineer firstEngineer = new Engineer("Peter Wangari", "[email protected]", "Tokyo", date);
        Engineer anotherEngineer = new Engineer("Fiona Wangui", "[email protected]", "Tokyo", date);
        assertTrue(firstEngineer.equals(anotherEngineer));
    }
    @Test
    public void save_insertsObjectIntoDatabase_Engineer() {
        Engineer testEngineer = new Engineer("Peter Wangari", "[email protected]", "Tokyo", date);
        testEngineer.save();
        assertTrue(Engineer.all().get(0).equals(testEngineer));
    }
    @Test
    public void all_returnsAllInstancesOfEngineer_true() {
        Engineer firstEngineer = new Engineer("Peter", "peter@mail.com", "Tokyo", date);
        firstEngineer.save();
        Engineer secondEngineer = new Engineer("Fiona", "fiona@mail.com", "Tokyo", date);
        secondEngineer.save();
        assertEquals(true, Engineer.all().get(0).equals(firstEngineer));
        assertEquals(true, Engineer.all().get(1).equals(secondEngineer));
    }
    @Test
    public void save_assignsIdToObject() {
        Engineer testEngineer = new Engineer("Gigi", "gigi@mail.com", "Tokyo", date);
        testEngineer.save();
        Engineer savedEngineer = Engineer.all().get(0);
        assertEquals(testEngineer.getId(), savedEngineer.getId());
    }
    @Test
    public void find_returnsEngineerWithSameId_secondEngineer() {
        Engineer firstEngineer = new Engineer("Henry", "henry@henry.com", "Tokyo", date);
        firstEngineer.save();
        Engineer secondEngineer = new Engineer("Harriet", "harriet@harriet.com", "Tokyo", date);
        secondEngineer.save();
        assertEquals(Engineer.find(secondEngineer.getId()), secondEngineer);
    }

}

