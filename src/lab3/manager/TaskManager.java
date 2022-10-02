package lab3.manager;

import lab3.Lector;

import java.util.*;

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
        // 1. create set of students (without repeats)
        // 2. go through lectorsList and compare studentName from set to List<String> where student names are contained
        // 3. if true, add to Map
        Map<String, List<String>> studentDisciplineMap = new HashMap<>();
        Set<String> studentsSet = new HashSet<>();
        for (var lector: inputDataFile1) {
            for (var student: lector.getStudentsList()) {
                studentsSet.add(student);
            }
        }
//        System.out.println(studentsSet);
        for (var student: studentsSet) {
            List<String> coursesForStudent = new ArrayList<>();
            for (var lector: inputDataFile1){
                if (lector.getStudentsList().contains(student)) {
                    coursesForStudent.add(lector.getCourseName());
                }
            }
            studentDisciplineMap.put(student, coursesForStudent);
        }
        OutputManager.ShowStudentDisciplineMap(studentDisciplineMap);
    }
}
