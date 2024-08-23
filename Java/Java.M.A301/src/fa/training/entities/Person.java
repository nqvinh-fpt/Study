package fa.training.entities;

public class Person {
    private String fullName;
    private String gender;

    private String dateOfBirth;
    private String phone;
    private String email;



    public Person() {
    }

    public Person(String fullName, String gender, String dateOfBirth, String phone, String email) {
        this.fullName = fullName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void purchaseParkingPass(){

    }
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String birthDate) {
        this.dateOfBirth = birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "fullName='" + fullName + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
