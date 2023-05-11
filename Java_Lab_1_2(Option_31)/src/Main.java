import Model.*;

import java.io.*;
import java.util.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Periodical> perdical = new ArrayList<>();
    private static ArrayList<Periodical> choicePeriodical = new ArrayList<>();
    private static ArrayList<User> person = new ArrayList<>();
    private static ArrayList<User> blockUser = new ArrayList<>();
    private static final String FILE_PATH1 = "ExistedPeriodical.data";
    public static void main(String[] args) throws MyExceptionClass {
        MainMenu();
    }

    private static void MainMenu() throws MyExceptionClass {
        System.out.println("\n1) Клиент\n" +
                "2) Админ\n" +
                "3) Сохранить\n" +
                "4) Загрузить\n" +
                "5) Показать сохраненные книги\n" +
                "0) Выйти из программы\n" +
                "---------------------");
        switch (scanner.nextInt()) {
            case 1: User();break;
            case 2: Admin();break;
            case 3: SavePeriodical();break;
            case 4: LoadPeriodical();break;
            case 5: ShowPeriodical();break;
            case 0: System.exit(0);break;
        }
    }

    private static void SavePeriodical() {
        try {
            FileOutputStream fos= new FileOutputStream(FILE_PATH1);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(perdical);
            oos.close();

            System.out.println("\nИздания сохранена!\n");
            MainMenu();
        } catch (IOException | MyExceptionClass e) {
            e.printStackTrace();
        }
    }

    private static void LoadPeriodical() {
        System.out.println("\nЗАГРУЗКА ФАЙЛА:");
        try {
            FileInputStream fis1 = new FileInputStream(FILE_PATH1);
            ObjectInputStream ois1 = new ObjectInputStream(fis1);
            perdical = (List<Periodical>) ois1.readObject();


            System.out.println("\nИздания загружена!\n");
            MainMenu();
        } catch (IOException | ClassNotFoundException | MyExceptionClass e) {
            e.printStackTrace();
        }
    }

    private static void ShowPeriodical() throws MyExceptionClass {
        for (int i = 0; i<perdical.size(); i++){
            System.out.println(i + ") " + perdical.get(i));
        }
        MainMenu();
    }

    private static void User() throws MyExceptionClass {
        System.out.println("\nВведите имя: ");

        UserPerson addUser = new UserPerson(true);
        addUser.setName(scanner.next());
        UserAge(addUser);
    }

    private static void UserAge(UserPerson addUser) throws MyExceptionClass {
        System.out.println("Введите возраст: ");
        int userAge = scanner.nextInt();
        if (userAge >= 100){
            throw new MyExceptionClass("Введите правильный возвраст");
        }else {
            addUser.setAge(userAge);
            ConditionUser(addUser);
        }
    }

    private static void ConditionUser(UserPerson addUser) throws MyExceptionClass {
        addUser.setCondition(true);
        person.add(addUser);

        ChoiceBook();
    }

    private static void ChoiceBook() throws MyExceptionClass {
        System.out.println("\n1) Выбрать издание\n" +
                "2) Сортировка\n" +
                "3) Список выбранных изданий\n" +
                "0) Главное меню\n" +
                "---------------");
        switch (scanner.nextInt()){
            case 1: PeriodicalChoice();break;
            case 2: SortPeriodicals();break;
            case 3: ArrayPeriodicals();break;
            case 0: MainMenu();break;}
    }

    private static void PeriodicalChoice() throws MyExceptionClass {
        System.out.println("\nСписок изданий:\n");
        for (int i = 0; i<perdical.size(); i++){
            System.out.println(i + ") " + perdical.get(i));
        }
        System.out.println("Выберите издания: ");
        int choicePayUser = scanner.nextInt();
        System.out.println("Хотите оплатить издание ?\n" +
                "1) Да\n" +
                "2) Нет не хочу");
        switch (scanner.nextInt()){
            case 1:
                choicePeriodical.add(perdical.get(choicePayUser));
                ChoiceBook();
                break;
            case 2:
                person.get(0).setCondition(false);
                blockUser.add(person.get(0));
                MainMenu();
                break;
        }
    }

    private static void SortPeriodicals() throws MyExceptionClass {
        System.out.println("1. По убыванию\n" +
                "2. По возврастанию\n" +
                "0. Назад");

        ArrayList<Periodical> periodicalSort = new ArrayList<>(perdical);

        switch (scanner.nextInt()) {
            case 1:
                System.out.println("\n");
                Collections.sort(periodicalSort);
                Collections.reverse(periodicalSort);
                System.out.println(periodicalSort);
                ChoiceBook();
                break;
            case 2:
                System.out.println("\n");
                Collections.sort(periodicalSort);
                System.out.println(periodicalSort);
                ChoiceBook();
                break;
            case 0:
                ChoiceBook();
                break;
        }
    }

    private static void ArrayPeriodicals() throws MyExceptionClass {
        for (Periodical v: choicePeriodical){
            System.out.println("Выбранное издание: " + v.toString());
        }
        ChoiceBook();
    }
    private static void Admin() throws MyExceptionClass {
        System.out.println("\n1) Создать издание\n" +
                "2) Просмотр заявок\n" +
                "3) Черный список\n" +
                "0) Главное меню\n" +
                "-----------------");

        switch (scanner.nextInt()){
            case 1: CreatePeriodical();break;
            case 2: ShowApplications();break;
            case 3: BlackList();break;
            case 0: MainMenu();break;}
    }

    private static void CreatePeriodical() throws MyExceptionClass {
        System.out.println("\nНазвание издания: ");
        Periodical periodical = new Periodical();

        periodical.setName(scanner.next());
        PagesBook(periodical);
    }

    private static void PagesBook(Periodical periodical) throws MyExceptionClass {
        System.out.println("Количество страниц: ");

        periodical.setPages(scanner.nextInt());
        YearBook(periodical);
    }

    private static void YearBook(Periodical periodical) throws MyExceptionClass {
        System.out.println("Год издания: ");

        periodical.setYear(scanner.nextInt());
        perdical.add(periodical);

        System.out.println("\nДобавить новое издание\n" +
                "1) Да\n" +
                "2) Админ панель\n" +
                "---------------");
        switch (scanner.nextInt()){
            case 1:
                CreatePeriodical();
                break;
            case 2:
                Admin();
                break;
        }
    }

    private static void ShowApplications() throws MyExceptionClass {
        for (Periodical v: choicePeriodical){
            System.out.println("Оформленные заявки: " + v.toString());
        }

        Admin();
    }

    private static void BlackList() throws MyExceptionClass {
        for (int i = 0; i < blockUser.size(); i++){
            if (blockUser.get(i).getCondition() != true){
                System.out.println(i + " " + blockUser.get(i));
            }
        }

        Admin();
    }
}
