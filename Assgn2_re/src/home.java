import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class home {
    public static void main(String args[]) {
        // String workingDir = System.getProperty("user.dir");
        // System.out.println("Current working directory : " + workingDir);
        try {
            employee emp = new employee("CEO");
            Scanner input = new Scanner(new File("test12.txt"));

            String answer = input.nextLine();
            int val = Integer.parseInt(answer);
            for (int i = 0; i < val-1; i++) {
                answer = input.nextLine();
                String[] splited = answer.split(" ");
                emp.AddEmployee(splited[0], splited[1]);
            }

            answer = input.nextLine();
            int op = Integer.parseInt(answer);

            for (int i = 0; i < op; i++) {
                String[] splited = answer.split(" ");
                int a = Integer.parseInt(splited[0]);
                if (a == 0) {
                    emp.AddEmployee(splited[1], splited[2]);
                } else if (a == 1) {
                    emp.DeleteEmployee(splited[1], splited[2]);
                } else if (a == 2) {
                    emp.LowestCommonBoss(splited[1], splited[2]);
                } else if (a == 3) {
                    emp.PrintEmployees();
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("failed");
            // insert code to run when exception occurs
        }

    }
}
