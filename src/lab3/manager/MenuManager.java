package lab3.manager;

import java.util.Scanner;

public class MenuManager {

    public void start() {
        Scanner scanner = new Scanner(System.in);
        int userInput = -1;

        do {
            System.out.print("""
                    -----
                    0. Вивести вхідну інформацію на екран
                    1. Створити таблицю, в першій колонці якої є прізвище студента, а в другій – перелік дисциплін, які він слухає.
                    2. Створити список студентів, які зараховані на всі дисципліни. Визначити спільних слухачів 2 заданих курсів.
                    3. З 2 різних файлів зчитати 2 вихідні набори інформації про викладачів. Створити спільну колекцію,
                       яка складатиметься з усіх викладачів, які мають кількість курсів вищу, від середньої по узагальненій колекції, без повторів.
                    4. Завершити роботу програми
                    ---->""");

            try {
                userInput = Integer.parseInt(scanner.next());
            }
            catch (NumberFormatException e) {
//                System.out.println(e);
                userInput = -1;
            }

            switch (userInput) {
                case 0:

                    break;
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    System.out.println("--\nРоботу програми завершено!\n--");
                    break;
                default:
                    System.out.println("--\nВведено неправильну цифру\n--");
            }
        } while (userInput != 4);
    }
}
