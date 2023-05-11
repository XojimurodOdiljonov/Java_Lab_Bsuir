import Model.Taxes;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Taxes> taxes = new ArrayList<>();
    private static final String FILE_PATH1 = "ExistedTaxes.data";
    public static void main(String[] args) throws MyExceptionClass {
        MainMenu();
    }

    private static void MainMenu() throws MyExceptionClass {
        System.out.println("Главный меню: \n" +
                "1. Добавить налог\n" +
                "2. Вывести налоги\n" +
                "3. Сортировка\n" +
                "4. Сохранить\n" +
                "5. Загрузить\n" +
                "0. Выход из программы");

        int choiceMenu = scanner.nextInt();
        switch (choiceMenu){
            case 1: AddTaxes();break;
            case 2: OutTaxes();break;
            case 3: SortTax();break;
            case 4: SaveTaxes();break;
            case 5: LoadTaxes();break;
            case 0: System.exit(0);break;
        }
    }

    private static void AddTaxes() throws MyExceptionClass {
        System.out.println("Введите ID для пользователя: ");
        Taxes person = new Taxes();
        person.setId(scanner.nextInt());

        System.out.println("Введите ФИО: ");
        person.setFIO(scanner.next());

        System.out.println("Введите вид Налога: ");
        person.setTypeTax(scanner.next());

        System.out.println("Введите процент налога: ");
        int percentTaxes = scanner.nextInt();
        if (percentTaxes >= 100){
            throw new MyExceptionClass("Выше лимита: ");
        } else{
            person.setCostTax(percentTaxes);
            taxes.add(person);

            MainMenu();
        }
    }

    private static void OutTaxes() throws MyExceptionClass {
        for (int i = 0; i < taxes.size(); i++) {
            System.out.println(i + " " + taxes.get(i));
        }
        MainMenu();
    }

    private static void SortTax() throws MyExceptionClass {
        System.out.println("1. По убыванию\n" +
                "2. По возврастанию\n" +
                "0. Назад");

        ArrayList<Taxes> copy = new ArrayList<>(taxes);

        int selectSort = scanner.nextInt();
        switch (selectSort) {
            case 1:
                Collections.sort(copy);
                System.out.println(copy);
                MainMenu();
                break;
            case 2:
                Collections.sort(copy);
                Collections.reverse(copy);
                System.out.println(copy);
                MainMenu();
                break;
            case 0:
                MainMenu();
                break;
        }
    }

    private static void SaveTaxes() {
        try {
            FileOutputStream fos= new FileOutputStream(FILE_PATH1);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(taxes);
            oos.close();

            System.out.println("\nНалоги сохранена!\n");
            MainMenu();
        } catch (IOException | MyExceptionClass e) {
            e.printStackTrace();
        }
    }

    private static void LoadTaxes() {
        System.out.println("\nЗАГРУЗКА ФАЙЛА:");
        try {
            FileInputStream fis1 = new FileInputStream(FILE_PATH1);
            ObjectInputStream ois1 = new ObjectInputStream(fis1);
            taxes = (List<Taxes>) ois1.readObject();


            System.out.println("\nНалоги загружена!\n");
            MainMenu();
        } catch (IOException | ClassNotFoundException | MyExceptionClass e) {
            e.printStackTrace();
        }
    }
}