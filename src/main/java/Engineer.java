import java.sql.Connection;

public class Engineer {
    private String name;
    private String email;

    public Engineer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
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
                    .executeUpdate();
        }
    }

}