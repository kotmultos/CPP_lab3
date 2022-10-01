package lab3.manager;

import lab3.Lector;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    public static List<Lector> GetLectorsFromFile(String filename) {
        ArrayList<Lector> res = new ArrayList<Lector>();

        try (FileReader reader = new FileReader(filename)) {
            Scanner scan = new Scanner(reader);
            while (scan.hasNextLine()) {
                String tmp = scan.nextLine();
                String[] arrTmp = tmp.split(";");
                String [] students = arrTmp[2].split(",");
                res.add(new Lector(arrTmp[0], arrTmp[1], Arrays.asList(arrTmp[2])));
            }
        } catch (IOException e) {
            System.out.println("An error occured while reading from file.///");
            System.out.println(e);
            return new ArrayList<Lector>();
//            throw new RuntimeException(e);

        }
        return res;
    }
}
