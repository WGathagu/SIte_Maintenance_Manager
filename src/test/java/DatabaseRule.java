import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

    @Override
    protected void before() {
        DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/site_maintenance_test", "admin", "admin");
    }

    @Override
    protected void after() {
        try(Connection con = DB.sql2o.open()) {
            String deletePersonsQuery = "DELETE FROM engineer *;";
            con.createQuery(deletePersonsQuery).executeUpdate();
        }
    }
    @Override
    protected void after() {
        try(Connection con = DB.sql2o.open()) {
            String deletePersonsQuery = "DELETE FROM engineer *;";
            String deleteMonstersQuery = "DELETE FROM sites *;";
            con.createQuery(deletePersonsQuery).executeUpdate();
            con.createQuery(deleteMonstersQuery).executeUpdate();
        }
    }

}