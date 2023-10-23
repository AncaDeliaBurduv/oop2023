package proiect2.entities;

public class Passenger {
    private String firstName;
    private String lastName;
    private String email;

    //constructor pasager fara email
    public Passenger(String firstName, String lastName){
        this.firstName=firstName;
        this.lastName=lastName;
        email=null;
    }

    //constructor fasager cu email
    public Passenger(String firstName, String lastName, String email){
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
    }

    //getter prenume
    public String getFirstName() {

        return firstName;
    }

    //setter prenume
    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    //getter nume
    public String getLastName() {
        return lastName;
    }

    //setter nume
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //getter email
    public String getEmail() {
        return email;
    }

    //setter email
    public boolean setEmail(String email) {
        if (email.matches("[A-Za-z0-9_.-]{1,64}@[A-Za-z0-9-]{1,64}\\.[A-Za-z]{2,10}")) {
            this.email = email;
            return true;
        }
        else{
            return false;
        }
    }

    //metoda toString
    @Override
    public String toString() {
        StringBuffer s=new StringBuffer();
        s.append(firstName);
        s.append(" ");
        s.append(lastName);
        if(null!=email) {
            s.append(" (");
            s.append(email);
            s.append(")");
        }
        return s.toString();
    }
}
