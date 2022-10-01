package lab3.manager;

import lab3.Lector;

import java.util.List;
import java.util.Scanner;

public class MenuManager {

    public static void start() {
        OutputManager.SetMenuVariants();

        Scanner scanner = new Scanner(System.in);
        int userInput = -1;

        do {
            OutputManager.ShowMenu();

            // створити список викладач - предмет - масив студентів --- вхідна інформація
            // створитит мапу<k,v> студент - масив предметів
            // задання 2 курсів вручну і пошук для них спільних слухачів -- також через якусь колекцію певно треба зробити
            // створити колекцію з викладачів з обох файлів - цікаво, теж якась колекція
            // піду вже спати крч


            try {
                userInput = Integer.parseInt(scanner.next());
            }
            catch (NumberFormatException e) {
                System.out.println(e);
                userInput = -1;
            }

            switch (userInput) {
                case 0:
                    TaskManager.ShowInputData();
                    break;
                case 1:
                    TaskManager.CreateStudentDisciplineTable();
                    break;
                case 2:

                    break;
                case 3:

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
