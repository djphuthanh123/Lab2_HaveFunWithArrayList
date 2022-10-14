import java.util.*;
import java.util.stream.Collectors;

public class StudentList {
    ArrayList<Student> students = new ArrayList<>();

    public StudentList() {
    }

    public StudentList(ArrayList<Student> students) {
        this.students = students;
    }


    public void showAllStudent() {
        showStudent(students);
    }

    public void showStudent(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("List is empty !");
        } else {
            for (Student n : students) {
                System.out.println(n.show());
            }
        }

    }



    public void addStudentIT() {
        String id = Validation.inputString("Enter student id : ");
        int check = checkId(id);
        while (check != -1) {
            System.out.print("Id already exist!\n");
            id = Validation.inputString("Enter student id : ");
            check = checkId(id);
        }
        String name = Validation.inputString("Enter Full Name : ");
        String city = Validation.inputString("Enter city: ");
        String country = Validation.inputString("Enter country");
        String stress = Validation.inputString("Enter stress: ");
        double javaScore = Validation.inputDouble("Enter Java score: ");
        double cssScore = Validation.inputDouble("Enter CSS Score: ");
        students.add(new StudentIT(id, name, new Address(new Country(country), stress, new City(city)), javaScore, cssScore));

    }

    public void addStudentBiz() {
        String id = Validation.inputString("Enter student id : ");
        int check = checkId(id);
        while (check != -1) {
            System.out.print("Id already exist!\n");
            id = Validation.inputString("Enter student id : ");
            check = checkId(id);
        }
        String name = Validation.inputString("Enter student name : ");
        String city = Validation.inputString("Enter city: ");
        String country = Validation.inputString("Enter country");
        String stress = Validation.inputString("Enter stress: ");
        double mktScore = Validation.inputDouble("Enter MKT score: ");
        double accScore = Validation.inputDouble("Enter acc Score: ");
        students.add(new StudentBiz(id, name, new Address(new Country(country), stress, new City(city)), mktScore, accScore));
    }


    public void sorting() {
        Collections.sort(students);
        for (Student st : students) {
            System.out.println(st.show());
            System.out.println();
        }
    }

    private int checkId(String id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }


    public int findIndex(String id){
        for (Student st : students) {
            if (st.getId().equalsIgnoreCase(id)) {
                st.show();
                return students.indexOf(st);
            }
        }
        return -1;
    }

    public ArrayList<Student> getListStudentById(String id) {
        ArrayList<Student> getListStudentById = new ArrayList<>();
        for (Student student : students) {
            if (id.equalsIgnoreCase(student.getId())) {
                getListStudentById.add(student);
            }
        }
        return getListStudentById;
    }

    public Student getStudentByListFound(ArrayList<Student> listStudentFindByID) {
        System.out.println("List student found: ");
        int count = 0;
        for (Student student : listStudentFindByID) {
            System.out.println("Index: "+(count++)+ "| " +student.getId() + " " + student.getFullName() + " " + student.getAddress());
        }
        int index = Validation.inputSelect("Enter index:", 0, listStudentFindByID.size()-1 );
        return listStudentFindByID.get(index);
    }

    public void updateORdelete() {
        String id = Validation.inputString("Select yout id");
        int index = findIndex(id);
        ArrayList<Student> listStudentFindByID = getListStudentById(id); // in ra list co cung id 
        if (listStudentFindByID.isEmpty()){
            System.out.println("not found !");
        }else {
            Student st = getStudentByListFound(listStudentFindByID);
            if (Validation.checkInputUD() ){
                if (st instanceof StudentIT){

                    String name = Validation.inputString("Enter name: ");
                    String city = Validation.inputString("Enter city: ");
                    String country = Validation.inputString("Enter country");
                    String stress = Validation.inputString("Enter stress: ");
                    double javaScore = Validation.inputDouble("Enter JavaScore: ");
                    double cssScore = Validation.inputDouble("Enter cssScore: ");
                    students.set(index, new StudentIT(id, name, new Address(new Country(country), stress, new City(city)), javaScore, cssScore));
                }else if(st instanceof StudentBiz){
                    String name = Validation.inputString("Enter name: ");
                    String city = Validation.inputString("Enter city: ");
                    String country = Validation.inputString("Enter country");
                    String stress = Validation.inputString("Enter stress: ");
                    String address = Validation.inputString("Enter Address: ");
                    double mktScore = Validation.inputDouble("Enter JavaScore: ");
                    double cssScore = Validation.inputDouble("Enter cssScore: ");
                    students.set(index, new StudentBiz(id, name, new Address(new Country(country), stress, new City(city)), mktScore, cssScore));
                }
            }else {
                students.remove(index);
            }

        }

    }
    public void menuUpdate(){
         String menuUpdate = """
                       MENU UPDATE          \s
            1. UPDATE NAME                  \s
            2. UPDATE CITY                  \s
            3. UPDATE STRESS                \s
            4. UPDATE COUNTRY               \s
            5. UPDATE SCORE1                \s  
            6. UPDATE SCORE2                \s""";
    }




    public void countStudentSameCity() {
        ArrayList<Student> st = new ArrayList<>();
        Map<Address, Long> count = students.stream().collect(Collectors.groupingBy(Student::getAddress,Collectors.counting()));
        System.out.println("Student same city: "+ count );

        Map<Object, List<Student>> groupedByCityAndStreet = students.stream()
                .collect(Collectors.groupingBy(
                        student -> new AbstractMap.SimpleEntry<>(student.getAddress().getCity(), student.getAddress().getStreet()),
                        Collectors.toList()
                ));

        groupedByCityAndStreet.forEach((k, v) -> {
            System.out.println("People associated with " + k + " ");
            v.forEach(student -> {
                System.out.println(student.show());
            });
        });

    }

    public void report() {
        for (Student st : students) {
            if (st.getScore2() >= 5 || st.getScore1() >= 5 && st.getGpa() >= 5) {
                System.out.println(st.show());
            }
        }
    }


    public void generationNewStudent() {
        students.add(new StudentIT("23", "Phan Thanh Thao", new Address(new Country("VietNam"), "", new City("Quang Nam")), 4.5, 5.2));
        students.add(new StudentBiz("1", "Duong Thanh Phu", new Address(new Country("VietNam"), "", new City("Quang Nam")), 3.2, 9));
        students.add(new StudentIT("32", "Le Hoang Anh", new Address(new Country("VietNam"), "", new City("Da Nang")), 10, 8));
        students.add(new StudentBiz("32", "Nguyen van Anh", new Address(new Country("VietNam"), "", new City("Da Lat")), 7, 1.5));
        students.add(new StudentBiz("4", "Huynh Thi Phuong", new Address(new Country("VietNam"), "", new City("Quang Nam")), 4.5, 2.5));
        students.add(new StudentIT("44", "Ngo Khanh Nguyen", new Address(new Country("VietNam"), "", new City("Da Nang")), 1, 2));
        students.add(new StudentBiz("2", "Vo Quoc Cong", new Address(new Country("VietNam"), "", new City("Da Nang")), 3, 6));
        students.add(new StudentIT("6", "Nguyen Thi Hanh", new Address(new Country("VietNam"), "", new City("Ha Noi")), 1, 5));
        students.add(new StudentBiz("7", "Hoang Tan Minh", new Address(new Country("VietNam"), "", new City("Sa Pa")), 0, 5));

    }


}

