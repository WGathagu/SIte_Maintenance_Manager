import org.sql2o.Connection;
import java.util.ArrayList;
import java.util.List;

public class Site {
    private String name;
    private int engineerId;
    private int id;

    public Site(String name, int engineerId) {
        this.name = name;
        this.engineerId = engineerId;
    }

    public String getName(){
        return name;
    }

    public int getEngineerId(){
        return engineerId;
    }
    public int getId(){
        return id;
    }
    @Override
    public boolean equals(Object otherSite){
        if (!(otherSite instanceof Site)) {
            return false;
        } else {
            Site newSite = (Site) otherSite;
            return this.getName().equals(newSite.getName()) &&
                    this.getEngineerId() == newSite.getEngineerId();
        }
    }
    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sites (name, engineerId) VALUES (:name, :engineerId)";
            this.id = (int) con.createQuery(sql, true)
                    .addParameter("name", this.name)
                    .addParameter("engineerId", this.engineerId)
                    .executeUpdate()
                    .getKey();
        }
    }
    public static List<Site> all() {
        String sql = "SELECT * FROM sites";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Site.class);
        }
    }

}
