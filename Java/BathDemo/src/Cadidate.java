public class Cadidate extends Person{
    private double gpa;

    public Cadidate(double gpa) {
        this.gpa = gpa;
    }

    public Cadidate(int id, String cadidateName, String gender, String birthDate, String email, double gpa) {
        super(id, cadidateName, gender, birthDate, email);
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}
