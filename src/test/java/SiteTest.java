import org.junit.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.sql2o.*;

public class SiteTest {

    //@Rule
    //public DatabaseRule database = new DatabaseRule();

    @Test
    public void site_instantiatesCorrectly_true() {
        Site testSite = new Site("Kyoto", 1);
        assertEquals(true, testSite instanceof Site);
    }
    @Test
    public void site_instantiatesWithName_String() {
        Site testSite = new Site("Kyoto", 1);
        assertEquals("Kyoto", testSite.getName());
    }
    @Test
    public void site_instantiatesWithEngineerId_int() {
        Site testSite = new Site("Kyoto", 1);
        assertEquals(1, testSite.getEngineerId());
    }
    @Test
    public void equals_returnsTrueIfNameAndEngineerIdAreSame_true() {
        Site testSite = new Site("Kyoto", 1);
        Site anotherSite = new Site("Kyoto", 1);
        assertTrue(testSite.equals(anotherSite));
    }
    @Test
    public void save_returnsTrueIfDescriptionsAretheSame() {
        Site testSite = new Site("Kyoto", 1);
        testSite.save();
        assertTrue(Site.all().get(0).equals(testSite));
    }
    @Test
    public void save_assignsIdToSite() {
        Site testSite = new Site("Bubbles", 1);
        testSite.save();
        Site savedSite = Site.all().get(0);
        assertEquals(savedSite.getId(), testSite.getId());
    }
    @Test
    public void all_returnsAllInstancesOfSite_true() {
        Site firstSite = new Site("Bubbles", 1);
        firstSite.save();
        Site secondSite = new Site("Spud", 1);
        secondSite.save();
        assertEquals(true, Site.all().get(0).equals(firstSite));
        assertEquals(true, Site.all().get(1).equals(secondSite));
    }

}
