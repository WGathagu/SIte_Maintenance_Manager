public class Employee {
    private String name;
    private String email;

    public Employee(String name, String email) {
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
    public boolean equals(Object otherPerson){
        if (!(otherPerson instanceof Employee)) {
            return false;
        } else {
            Employee newPerson = (Employee) otherPerson;
            return this.getName().equals(newPerson.getName()) &&
                    this.getEmail().equals(newPerson.getEmail());
        }
    }

}