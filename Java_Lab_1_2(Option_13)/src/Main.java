import Models.Coffee;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Coffee> coffees = new ArrayList<>();
    private static ArrayList<Coffee> vanCoffee = new ArrayList<>();
    private static final String FILE_PATH1 = "ExistedCoffee.data";
    public static void main(String[] args) {
        MainMenu();
    }

    private static void MainMenu() {
        System.out.println("\nГлавный меню: \n" +
                "1) Добавить кофе\n" +
                "2) Создать фургон\n" +
                "3) Показать фургон\n" +
                "4) Сортировка\n" +
                "5) Найти\n" +
                "6) Список кофе\n" +
                "7) Сохранить\n" +
                "8) Загрузить");

        switch (scanner.nextInt()){
            case 1: AddCoffee();break;
            case 2: CreateVan();break;
            case 3: ShowVan();break;
            case 4: SortCoffee();break;
            case 5: SearchCoffee();break;
            case 6: ShowListCoffee();break;
            case 7: SaveCoffee();break;
            case 8: LoadCoffee();break;
        }
    }

    private static void ShowListCoffee() {
        System.out.println("Список кофе: ");
        for (int i = 0; i < coffees.size(); i++){
            System.out.println(i + ") " + coffees.get(i));
        }

        MainMenu();
    }

    private static void SaveCoffee() {
        try {
            FileOutputStream fos= new FileOutputStream(FILE_PATH1);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(coffees);
            oos.close();

            System.out.println("\nКофе сохранена!\n");
            MainMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void LoadCoffee() {
        System.out.println("\nЗАГРУЗКА ФАЙЛА:");
        try {
            FileInputStream fis1 = new FileInputStream(FILE_PATH1);
            ObjectInputStream ois1 = new ObjectInputStream(fis1);
            coffees = (List<Coffee>) ois1.readObject();


            System.out.println("\nКофе загружена!\n");
            MainMenu();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void AddCoffee() {
        System.out.println("Дайте название кофе: ");

        Coffee coffeeAdd = new Coffee();
        coffeeAdd.setName(scanner.next());

        System.out.println("Введите цену: ");
        coffeeAdd.setPrice(scanner.nextInt());

        System.out.println("Выберите состав кофе: \n" +
                "1) Арабика\n" +
                "2) Робуста\n" +
                "3) Либерика\n" +
                "4) Эксцельса");
        switch (scanner.nextInt()){
            case 1:
                coffeeAdd.setTotal("Арабика");
                coffees.add(coffeeAdd);
                System.out.println("\nКофе успешно созданна");
                MainMenu();
                break;
            case 2:
                coffeeAdd.setTotal("Робуста");
                coffees.add(coffeeAdd);
                System.out.println("\nКофе успешно созданна");
                MainMenu();
                break;
            case 3:
                coffeeAdd.setTotal("Либерика");
                coffees.add(coffeeAdd);
                System.out.println("\nКофе успешно созданна");
                MainMenu();
                break;
            case 4:
                coffeeAdd.setTotal("Эксцельса");
                coffees.add(coffeeAdd);
                System.out.println("\nКофе успешно созданна");
                MainMenu();
                break;
        }
    }

    private static void CreateVan() {
        System.out.println("Выберите кофе для фургона: ");
        for (int i = 0; i < coffees.size(); i++){
            System.out.println(i + ") " + coffees.get(i));
        }
        int choiceCoffee = scanner.nextInt();
        vanCoffee.add(coffees.get(choiceCoffee));
        System.out.println("Ввывод фургона: ");
        for (Coffee v: vanCoffee){
            System.out.println(v.toString());
        }

        MainMenu();
    }

    private static void ShowVan() {
        System.out.println("Ввывод фургона: ");
        for (Coffee v: vanCoffee){
            System.out.println(v.toString());
        }

        MainMenu();
    }

    private static void SortCoffee() {
        System.out.println("1. По убыванию\n" +
                "2. По возврастанию\n" +
                "0. Назад");

        ArrayList<Coffee> copy = new ArrayList<>(coffees);

        int selectSort = scanner.nextInt();
        switch (selectSort) {
            case 1:
                Collections.sort(copy);
                Collections.reverse(copy);
                System.out.println("\n" + copy);
                MainMenu();
                break;
            case 2:
                Collections.sort(copy);
                System.out.println("\n" + copy);
                MainMenu();
                break;
            case 0:
                MainMenu();
                break;
        }
    }

    private static void SearchCoffee() {
        System.out.println("Поис по цене - \n" +
                "Ведите минимальную цену:");
        int minimumPrice = scanner.nextInt();
        System.out.println("Ведите максимальную цену:");
        int maximumPrice = scanner.nextInt();

        List<Coffee> filtered = coffees
                .stream()
                .filter(t -> t.getPrice() <= maximumPrice && t.getPrice() >= minimumPrice)
                .collect(Collectors.toList());
        System.out.println(filtered);

        MainMenu();
    }
}