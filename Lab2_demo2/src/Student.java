import java.util.Objects;

abstract public class Student implements Comparable<Student> {
    private String id, fullName;
    private Address address;
    private double score1, score2, gpa;

    public Student() {
    }

    public Student(String id, String fullName, Address address, double score1, double score2) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.score1 = score1;
        this.score2 = score2;
        this.gpa = gpa;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public double getScore1() {
        return score1;
    }

    public void setScore1(double score1) {
        this.score1 = score1;
    }

    public double getScore2() {
        return score2;
    }

    public void setScore2(double score2) {
        this.score2 = score2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Double.compare(student.getScore1(), getScore1()) == 0 && Double.compare(student.getScore2(), getScore2()) == 0 && Double.compare(student.getGpa(), getGpa()) == 0 && getId().equals(student.getId()) && getFullName().equals(student.getFullName()) && getAddress().equals(student.getAddress());
    }


    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFullName(), getAddress(), getScore1(), getScore2(), getGpa());
    }

    abstract public double getGpa();

    abstract void setGpa(double gpa);

    abstract public String show();

    abstract double avgGpa();
}