
import org.sql2o.Connection;

import java.util.Date;
import java.util.List;

public class Engineer {
    private String name;
    private String email;
    private String sitename;
    private Date hiredate;
    private int id;

    public Engineer(String name, String email, String sitename, Date hiredate) {
        this.name = name;
        this.email = email;
        this.sitename = sitename;
        this.hiredate = hiredate;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getSiteName() {
        return sitename;
    }

    public Date getHireDate() {
        return hiredate;
    }
    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object otherEngineer){
        if (!(otherEngineer instanceof Engineer)) {
            return false;
        } else {
            Engineer newEngineer = (Engineer) otherEngineer;
            return this.getName().equals(newEngineer.getName()) &&
                    this.getEmail().equals(newEngineer.getEmail());
        }
    }

    public void save() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO engineer (name, email, site_name, hire_date) VALUES (:name, :email, :site_name, :hire_date)";
            con.createQuery(sql)
                    .addParameter("name", this.name)
                    .addParameter("email", this.email)
                    .addParameter("site_name", this.sitename)
                    .addParameter("hire_date", this.hiredate)
                    .executeUpdate()
                    .getKey();
        }
    }

    public static List<Engineer> all() {
        String sql = "SELECT * FROM engineer";
        try(Connection con = DB.sql2o.open()) {
            return con.createQuery(sql).executeAndFetch(Engineer.class);
        }
    }
    public static Engineer find(int id) {
        try(Connection con = DB.sql2o.open()) {
            String sql = "SELECT * FROM engineer where id=:id";
            Engineer Engineer = con.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Engineer.class);
            return Engineer;
        }
    }

}