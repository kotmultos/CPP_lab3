package lab3;

import java.util.List;

public class Lector {
    private String surname;
    private String courseName;
    private List<String> studentsList;


    public Lector(String surname, String courseName, List<String> studentsList) {
        this.surname = surname;
        this.courseName = courseName;
        this.studentsList = studentsList;
    }

    public String getSurname() {
        return surname;
    }

    public String getCourseName() {
        return courseName;
    }

    public List<String> getStudentsList() {
        return studentsList;
    }

    @Override
    public String toString() {
        return String.format("%-16s%-16s%-25s", surname, courseName, studentsList.toString());
    }
}
