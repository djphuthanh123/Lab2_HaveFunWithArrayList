import java.util.Scanner;

public class Validation {
    static Scanner sc = new Scanner(System.in);

    public static String inputString(String string) {
        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print(string);
            String str = in.nextLine();
            if (!str.isEmpty()) {
                return str;
            } else {
                System.out.println("String cannot be empty!");
            }
        }
    }

    public static int inputInteger(String string) {
        Scanner in = new Scanner(System.in);
        int n = 0;
        while (true) {
            try {
                System.out.print(string);
                n = Integer.parseInt(in.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println("Required Score need to be >= 0 and <= 10");
            }
        }
    }


    public static double inputDouble(String string) {
        Scanner in = new Scanner(System.in);
        double n = 0;
        while (true) {
            try {
                System.out.print(string);
                n = Double.parseDouble(in.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println("Required positive integer!");
            }
        }
    }
     

    public static boolean checkInputUD() {
        while (true) {
            String result = inputString("Select U/update or D/delete: ");
            if (result.equalsIgnoreCase("U")) {
                return true;
            }
            if (result.equalsIgnoreCase("D")) {
                return false;
            }
            System.err.println("Please input u/U or d/D.");
            System.out.print("Enter again: ");
        }
    }


}
