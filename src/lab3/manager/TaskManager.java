package lab3.manager;

import lab3.Lector;

import java.util.List;

public class TaskManager {
    static  List<Lector> inputDataFile1 = FileManager.GetLectorsFromFile("lector1.txt");
    static  List<Lector> inputDataFile2 = FileManager.GetLectorsFromFile("lector2.txt");

    public static void ShowInputData() {
        System.out.println(String.format("%-16s%-16s%-25s", "Lector", "Discipline", "Students"));
        System.out.println("File 1");
        OutputManager.ShowLectorList(inputDataFile1);
        System.out.println("File 2");
        OutputManager.ShowLectorList(inputDataFile2);
    }

    public static void CreateStudentDisciplineTable() {
        // to be implemented
    }
}
