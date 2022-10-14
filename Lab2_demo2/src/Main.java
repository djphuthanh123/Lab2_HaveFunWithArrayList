public class Main {

    static String menu = """
              WELCOME TO STUDENT MANAGEMENT \s
            1. ADD STUDENT IT               \s
            2. ADD STUDENT BIZ              \s
            3. SHOW ALL STUDENT             \s
            4. SORTING AND PRINT            \s
            5. UPDATE OR DELETE             \s  
            6. COUNT STUDENT SAME CITY      \s
            7. REPORT Score 1,Score 2 or GPA >=5  \s""";

    public static int printMenu() {
        System.out.println(menu);
        return Validation.inputInteger("Enter your choice : ");
    }

    public static void main(String[] args) {
        StudentList st = new StudentList();
        st.generationNewStudent();
        int choose;

        do {
            choose = printMenu();
            switch (choose) {
                case 1 -> st.addStudentIT();
                case 2 -> st.addStudentBiz();
                case 3 -> st.showAllStudent();
                case 4 -> st.sorting();
                case 5 -> st.updateORdelete();
                case 6 -> st.countStudentSameCity();
                case 7 -> st.report();
            }
        } while (choose != 8);

    }
}