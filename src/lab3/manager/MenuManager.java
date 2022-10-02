package lab3.manager;

public class MenuManager {

    public static void start() {
        OutputManager.SetMenuVariants();

        int userInput;

        do {
            OutputManager.ShowMenu();
            userInput = InputManager.GetUserInputInt();

            switch (userInput) {
                case 0:
                    TaskManager.ShowInputData();
                    break;
                case 1:
                    TaskManager.CreateStudentDisciplineTable();
                    break;
                case 2:
                    TaskManager.FindStudentsFromAllCourses();
                    TaskManager.FindCommonStudentsOfDisciplines();
                    break;
                case 3:
                    TaskManager.FindLectorsWithMoreThanAvgCourses();
                    break;
                case 4:
                    System.out.println("--\nРоботу програми завершено!\n--");
                    break;
                default:
                    System.out.println("--\nВведено неправильну цифру. Повторіть спробу\n--");
            }
        } while (userInput != 4);
    }
}
