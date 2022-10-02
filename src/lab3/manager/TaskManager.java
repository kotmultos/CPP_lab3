package lab3.manager;

import lab3.Lector;

import java.util.*;

public class TaskManager {
    static  List<Lector> inputDataFile1 = InputManager.GetLectorsFromFile("lector1.txt");
    static  List<Lector> inputDataFile2 = InputManager.GetLectorsFromFile("lector2.txt");

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

    public static void FindStudentsFromAllCourses() {
        // create s set of all students
        // foreach on lectorsList: if each Lector course contain this student, add to list of students
        List<String> studentsFromAllCoursesList = new ArrayList<>();
        Set<String> studentsSet = new HashSet<>();
        for (var lector: inputDataFile1) {
            for (var student: lector.getStudentsList()) {
                studentsSet.add(student);
            }
        }

        for (var student: studentsSet) {
            boolean flag = true;
            for (var lector : inputDataFile1) {
                if(!lector.getStudentsList().contains(student)) {
                    flag = false;
                    break;
                }
            }
            if (flag) studentsFromAllCoursesList.add(student);
        }

        OutputManager.ShowStudentsList("Студенти, які вчаться на всіх курсах:", studentsFromAllCoursesList);
    }

    public static void FindCommonStudentsOfDisciplines() {
        var discipline1 = InputManager.GetUserInputString("Введіть назву першої дисципліни: ");
        var discipline2 = InputManager.GetUserInputString("Введіть назву другої дисципліни: ");

        // check if input strings are real courses
        // go through students of 1st course & check id they are contained in the second
        // if so, add
        // show final list

        int i1 = -1;
        int i2 = -1;
        for(int i = 0; i < inputDataFile1.size(); i++) {
            if(inputDataFile1.get(i).getCourseName().equals(discipline1)) i1 = i;
            if(inputDataFile1.get(i).getCourseName().equals(discipline2)) i2 = i;
        }

        List<String> commonStudents = new ArrayList<>();

        if(i1 == -1 || i2 == -1)  {
            System.out.println("Ведено назву курсу (курсів), яких не існує в програмі.");
        }
        else {
            for (var students1: inputDataFile1.get(i1).getStudentsList()) {
                if(inputDataFile1.get(i2).getStudentsList().contains(students1)) {
                    commonStudents.add(students1);
                }
            }
            OutputManager.ShowStudentsList("Спільні студенти з курсів " + discipline1 + " та " + discipline2, commonStudents);
        }
    }

    public static void FindLectorsWithMoreThanAvgCourses() {
        Map<String, Integer> res = new HashMap<>();
        List<Lector> allLectorsList = new ArrayList<>();

        allLectorsList.addAll(inputDataFile1);
        allLectorsList.addAll(inputDataFile2);

//        OutputManager.ShowLectorList(allLectorsList);
        Map<String, Integer> lectorCoursesCountMap = new HashMap<>();
        Set<String> lectorSurnames = new HashSet<>();
        for (var lector: allLectorsList) {
            lectorSurnames.add(lector.getSurname());
        }

        for (var lectorSurname: lectorSurnames) {
            lectorCoursesCountMap.put(lectorSurname, 0);
        }

        for (var key: lectorCoursesCountMap.keySet()) {
            for (var lector : allLectorsList) {
                if (lector.getSurname().equals(key)) {
                    lectorCoursesCountMap.put(key, lectorCoursesCountMap.get(key) + 1);
                }
            }
        }

        OutputManager.ShowLectorCoursesMap("Кількість курсів у кожного викладача:", lectorCoursesCountMap);
        int averCount = 0;
        for (var value: lectorCoursesCountMap.values()) { averCount+=value;}
        averCount /= lectorCoursesCountMap.size();

        for (var key: lectorCoursesCountMap.keySet()) {
            if(lectorCoursesCountMap.get(key) > averCount) {
                res.put(key, lectorCoursesCountMap.get(key));
            }
        }
        OutputManager.ShowLectorCoursesMap("Викладачі, які мають курсів більше, ніж середня кількість (" + averCount +"):", res);
    }
}
