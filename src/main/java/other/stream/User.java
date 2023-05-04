package other.stream;

public class User {
    private String firstname;
    private String lastname;
    private boolean isPremium;

    public User(String firstname, String lastname, boolean isPremium) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.isPremium = isPremium;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", isPremium=" + isPremium +
                '}';
    }
}
