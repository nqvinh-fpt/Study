public class Person {
    private int id;

    private String cadidateName;

    private String gender;
    private String birthDate;
    private String email;

    public Person() {
    }

    public Person(int id, String cadidateName, String gender, String birthDate, String email) {
        this.id = id;
        this.cadidateName = cadidateName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCadidateName() {
        return cadidateName;
    }

    public void setCadidateName(String cadidateName) {
        this.cadidateName = cadidateName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
