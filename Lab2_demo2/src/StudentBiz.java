public class StudentBiz extends Student {

    private double mktScore, accScore;

    public StudentBiz(String id, String fullName, Address address, double mktScore, double accScore) {
        super(id, fullName, address, mktScore, accScore);
        this.mktScore = mktScore;
        this.accScore = accScore;
    }

    @Override
    public double getGpa() {
        return avgGpa();
    }

    @Override
    void setGpa(double gpa) {

    }


    public double getMktScore() {
        return mktScore;
    }

    public void setMktScore(double mktScore) {
        this.mktScore = mktScore;
    }

    public double getAccScore() {
        return accScore;
    }

    public void setAccScore(double accScore) {
        this.accScore = accScore;
    }


    @Override
    public String show() {
        return " [STUDENT BIZ] "
                + "ID: " + getId()
                + ", FULL NAME: " + getFullName()
                + ", MKT SCORE: " + mktScore
                + ", ACC SCORE: " + accScore
                + ", GPA: " + getGpa()
                + ", ADDRESS: " + getAddress();
    }

    @Override
    double avgGpa() {
        return Math.floor(mktScore + accScore * 2) / 3;
    }


    @Override
    public int compareTo(Student o) {
        String[] b1 = this.getFullName().split(" ");
        int lastIndexOfb1 = b1.length -1;
        String[] b2 = o.getFullName().split(" ");
        int lastIndexOfb2 = b2.length -1;
        return b1[lastIndexOfb1].compareTo(b2[lastIndexOfb2]);
    }
}
