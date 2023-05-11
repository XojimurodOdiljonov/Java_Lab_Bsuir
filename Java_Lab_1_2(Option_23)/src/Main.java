import Models.Library;
import Models.Person;
import Models.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Library> libraries = new ArrayList<>();
    private static ArrayList<Library> homeBook = new ArrayList<>();
    private static ArrayList<Library> librarieBook = new ArrayList<>();
    private static ArrayList<Person> people = new ArrayList<>();
    private static ArrayList<Person> blockUser = new ArrayList<>();
    private static final String FILE_PATH1 = "ExistedVegetable.data";
    public static void main(String[] args) throws MyExceptionClass {
        MainMenu();
    }

    private static void MainMenu() throws MyExceptionClass {
        System.out.println("\nВход как: \n" +
                "1. Админ\n" +
                "2. Пользователь\n" +
                "3. Сохранить\n" +
                "4. Загрузить\n" +
                "5. Показать сохраненные книги");
        
        switch (scanner.nextInt()){
            case 1: Admin();break;
            case 2: User();break;
            case 3: SaveVegetable();break;
            case 4: LoadVegetable();break;
            case 5: ShowSaveBook();break;}
    }

    private static void SaveVegetable() {
        try {
            FileOutputStream fos= new FileOutputStream(FILE_PATH1);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(libraries);
            oos.close();

            System.out.println("\nКнига сохранена!\n");
            MainMenu();
        } catch (IOException | MyExceptionClass e) {
            e.printStackTrace();
        }
    }

    private static void LoadVegetable() {
        System.out.println("\nЗАГРУЗКА ФАЙЛА:");
        try {
            FileInputStream fis1 = new FileInputStream(FILE_PATH1);
            ObjectInputStream ois1 = new ObjectInputStream(fis1);
            libraries = (List<Library>) ois1.readObject();


            System.out.println("\nКнига загружена!\n");
            MainMenu();
        } catch (IOException | ClassNotFoundException | MyExceptionClass e) {
            e.printStackTrace();
        }
    }

    private static void ShowSaveBook() throws MyExceptionClass {
        for (int i = 0; i < libraries.size(); i++) {
            System.out.println(i + " " + libraries.get(i));
        }
        MainMenu();
    }

    private static void Admin() throws MyExceptionClass {
        System.out.println("1. Добавить книгу\n" +
                "2. Блокировка пользователья\n" +
                "3. Разблокировка пользователья\n" +
                "4. Показать черный список\n" +
                "5. Показать пользователей\n");

        switch (scanner.nextInt()){
            case 1:
                AddBook();
                break;
            case 2:
                BlockUser();
                break;
            case 3:
                UnblockUser();
                break;
            case 4:
                BlackList();
                break;
            case 5:
                ShowUser();
                break;
        }
    }

    private static void AddBook() throws MyExceptionClass {
        System.out.println("Добавление книги\n" +
                "Введите ID книги: ");

        Library book = new Library();
        book.setId(scanner.nextInt());
        NameBook(book);
    }

    private static void NameBook(Library book) throws MyExceptionClass {
        System.out.println("Введите название книги: ");
        book.setName(scanner.next());
        PagesBook(book);
    }

    private static void PagesBook(Library book) throws MyExceptionClass {
        System.out.println("Укажите страниц: ");
        book.setPages(scanner.nextInt());
        libraries.add(book);
        System.out.println("Книга успешно добавлена");
        MainMenu();
    }

    private static void BlockUser() throws MyExceptionClass {
        for (int i = 0; i < people.size(); i++){
            System.out.println(i + " " + people.get(i));
        }

        System.out.println("Выберите пользователя чтобы бокировать: ");
        int choiceUser = scanner.nextInt();
        people.get(choiceUser).setCondition(false);
        blockUser.add(people.get(choiceUser));

        Admin();
    }

    private static void BlackList() throws MyExceptionClass {
        for (int i = 0; i < blockUser.size(); i++){
            if (blockUser.get(i).getCondition() != true){
                System.out.println(i + " " + blockUser.get(i));
            }
        }
        System.out.println("Хотите разблокироваит: \n" +
                "1. да\n" +
                "2. Нет на Админку");
        switch (scanner.nextInt()){
            case 1:
                UnblockUser();
                break;
            case 2:
                Admin();
                break;
        }
    }

    private static void UnblockUser() throws MyExceptionClass {
        System.out.println("Выберите пользоваителья чтобы разлблокировать: ");
        for (int i = 0; i < blockUser.size(); i++){
            System.out.println(i + " " + blockUser.get(i));
        }
        int whiteUnlockUser = scanner.nextInt();
        blockUser.get(whiteUnlockUser).setCondition(true);

        Admin();
    }

    private static void ShowUser() throws MyExceptionClass {
        for (int i = 0; i < people.size(); i++){
            if (people.get(i).getCondition() != false){
                System.out.println(i + " " + people.get(i));
            }
        }
        Admin();
    }

    private static void User() throws MyExceptionClass {
        System.out.println("Регистрация пользователя: \n" +
                "Введите Имя: ");

        User userPerson = new User(true);
        userPerson.setName(scanner.next());
        UserAge(userPerson);
    }

    private static void UserAge(User userPerson) throws MyExceptionClass {
        System.out.println("Введите возвраст: ");
        int userAge = scanner.nextInt();
        if (userAge >= 100){
            throw new MyExceptionClass("Введите правильный возвраст");
        }else {
            userPerson.setAge(userAge);
            userPerson.setCondition(true);
            people.add(userPerson);

            ChoiceBook();
        }
    }

    private static void ChoiceBook() throws MyExceptionClass {
        System.out.println("Выберите пункт: \n" +
                "1. С собой забрать книгу\n" +
                "2. Читать в библиотеке\n" +
                "3. На Главный Меню");

        switch (scanner.nextInt()){
            case 1:
                System.out.println("Выберите книгу для чтения: ");
                for (int i = 0; i < libraries.size(); i++) {
                    System.out.println(i + " " + libraries.get(i));
                }
                int choiceBook = scanner.nextInt();
                homeBook.add(libraries.get(choiceBook));
                for (Library v: homeBook
                ) {
                    System.out.println("Выбранная книга домой: " + v.toString());
                }

                MainMenu();
                break;
            case 2:
                System.out.println("Выберите книгу для чтения: ");
                for (int i = 0; i < libraries.size(); i++) {
                    System.out.println(i + " " + libraries.get(i));
                }
                int choiceLibrary = scanner.nextInt();
                librarieBook.add(libraries.get(choiceLibrary));
                for (Library v: librarieBook
                ) {
                    System.out.println("Выбранная книга для чтения в библиотеке: " + v.toString());
                }

                MainMenu();
                break;
            case 3:
                MainMenu();
                break;
        }
    }
}