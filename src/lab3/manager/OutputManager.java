package lab3.manager;

import lab3.Lector;

import java.util.ArrayList;
import java.util.List;

public class OutputManager {
    static List<String> menuVariants = new ArrayList<String>();

     static void SetMenuVariants() {
        menuVariants.add("-----\n");
        menuVariants.add("0. Вивести вхідну інформацію на екран\n");
        menuVariants.add("1. Створити таблицю, в першій колонці якої є прізвище студента, а в другій – перелік дисциплін, які він слухає.\n");
        menuVariants.add("2. Створити список студентів, які зараховані на всі дисципліни. Визначити спільних слухачів 2 заданих курсів.\n");
        menuVariants.add("3. З 2 різних файлів зчитати 2 вихідні набори інформації про викладачів. Створити спільну колекцію,\n" +
                         "   яка складатиметься з усіх викладачів, які мають кількість курсів вищу, від середньої по узагальненій колекції, без повторів.\n");
        menuVariants.add("4. Завершити роботу програми\n");
        menuVariants.add("---->: ");
    }

    public static void ShowMenu() {
        for (var variant: menuVariants) {
            System.out.print(variant);
        }
    }

    public static void ShowLectorList(List<Lector> list) {
        for (var item: list) {
            System.out.println(item);
        }
    }
}
