package lab3.manager;

import lab3.Lector;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputManager {
    static Scanner scanner = new Scanner(System.in);
    public static List<Lector> GetLectorsFromFile(String filename) {
        ArrayList<Lector> res = new ArrayList<Lector>();

        try (FileReader reader = new FileReader(filename)) {
            Scanner scan = new Scanner(reader);
            while (scan.hasNextLine()) {
                String tmp = scan.nextLine();
                String[] arrTmp = tmp.split(";");
                String [] students = arrTmp[2].split(",");
                res.add(new Lector(arrTmp[0], arrTmp[1], Arrays.asList(students)));
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading from file./// filename: " + filename);
            System.out.println(e);
            return new ArrayList<Lector>();
        }
        return res;
    }
    public static int GetUserInputInt(){
        int res;
        try {
            res = Integer.parseInt(scanner.next());
        }
        catch (NumberFormatException e) {
            System.out.println(e);
            res = -1;
        }
        return res;
    }
    public static String GetUserInputString(String description) {
        System.out.print(description);
        String res = scanner.next();
        return res;
    }
}
