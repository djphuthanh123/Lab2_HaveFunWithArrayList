public class StudentIT extends Student{
    private final double javaScore;
    private final double cssScore;

    public StudentIT(String id, String fullName, Address address, double javaScore, double cssScore) {
        super(id, fullName, address, javaScore,cssScore);
        this.javaScore = javaScore;
        this.cssScore = cssScore;
    }

    @Override
    public double getGpa() {
        return avgGpa();
    }

    @Override
    void setGpa(double gpa) {

    }

    @Override
    public String show() {
        return " [STUDENT IT] "
                + "ID: " + getId()
                + ", FULL NAME: " + getFullName()
                + ", JAVA SCORE: " + javaScore
                + ", CSS SCORE: " + cssScore
                + ", GPA: " + getGpa()
                + ", ADDRESS: " + getAddress();
    }

    @Override
    double avgGpa() {
        return (3 * javaScore + cssScore) / 4;
    }

    @Override
    public int compareTo(Student o) {
       String[] f1= this.getFullName().split(" ");
       String[] f2 = o.getFullName().split(" ");
       return f1[f1.length-1].compareTo(f2[f2.length-1]);
    }
}