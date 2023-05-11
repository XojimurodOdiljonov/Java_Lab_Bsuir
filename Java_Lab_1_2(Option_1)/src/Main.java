import Models.Flower;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Flower> allFlower = new ArrayList<>();
    private static final String FILE_PATH1 = "ExistedToy.data";
    public static void main(String[] args) throws MyException {
        MainMenu();
    }

    private static void MainMenu() throws MyException {
        System.out.println("\nМеню: \n" +
                "1. Добавить цветы в букет\n" +
                "2. Добавить аксесуары в букет\n" +
                "3. Общая стоимость цветов\n" +
                "4. Сортировка\n" +
                "5. Поиск\n" +
                "6. Сохранить\n" +
                "7. Загрузить\n" +
                "8. Вывести все цветы");

        switch (scanner.nextInt()) {
            case 1: AddFlower();break;
            case 2: AddAccessory();break;
            case 3: AllPriceFlower();break;
            case 4: Sort();break;
            case 5: Search();break;
            case 6: Save();break;
            case 7: Load();break;
            case 8: ShowListFlower();break;
        }
    }

    private static void AddFlower() throws MyException {
        System.out.println("Выберите вид цветка\n" +
                "1. Розу\n" +
                "2. Пиона");

        Flower flower = new Flower();

        switch (scanner.nextInt()) {
            case 1: flower.setName("Розу");TypePrice(flower);break;
            case 2: flower.setName("Пиона");TypePrice(flower);break;
        }
    }

    private static void TypePrice(Flower flower) throws MyException {
        System.out.println("Укажите цену: ");
        flower.setPrice(scanner.nextInt());
        System.out.println("Укажите длину стеблей: ");
        int lengthFlower = scanner.nextInt();
        if (lengthFlower >= 100){
            throw new MyException("Введите меньше 100м");
        }else {
            flower.setLength(lengthFlower);
            allFlower.add(flower);

            MainMenu();
        }
    }

    private static void AddAccessory() throws MyException {
        System.out.println("Выберите тип аксесуара: \n" +
                "1. Лента\n" +
                "2. Блестки");
        Flower flower = new Flower();
        switch (scanner.nextInt()) {
            case 1:
                flower.setAccessory("Лента");
                System.out.println("Укажите цену: ");
                flower.setPrice(scanner.nextInt());
                allFlower.add(flower);

                MainMenu();
                break;
            case 2:
                flower.setAccessory("Блестки");
                System.out.println("Укажите цену: ");
                flower.setPrice(scanner.nextInt());
                allFlower.add(flower);

                MainMenu();
                break;
        }
    }

    private static void AllPriceFlower() throws MyException {
        int sum = allFlower.stream().mapToInt((Flower::getPrice)).sum();
        System.out.println("Общая сумма цветов: " + sum);

        MainMenu();
    }

    private static void Sort() throws MyException {
        System.out.println("1. По убыванию\n" +
                "2. По возврастанию\n");

        ArrayList<Flower> copy = new ArrayList<>(allFlower);

        switch (scanner.nextInt()) {
            case 1:
                Collections.sort(copy);
                Collections.reverse(copy);
                System.out.println(copy);

                MainMenu();
                break;
            case 2:
                Collections.sort(copy);
                System.out.println(copy);

                MainMenu();
                break;
        }
    }

    private static void Search() throws MyException {
        System.out.println("Поис по цене - \n" +
                "Ведите минимальную цену:");
        int minimumPrice = scanner.nextInt();
        System.out.println("Ведите максимальную цену:");
        int maximumPrice = scanner.nextInt();

        List<Flower> filtered = allFlower
                .stream()
                .filter(t -> t.getPrice() <= maximumPrice && t.getPrice() >= minimumPrice)
                .collect(Collectors.toList());
        System.out.println(filtered);

        MainMenu();
    }

    private static void Save() {
        try {
            FileOutputStream fos= new FileOutputStream(FILE_PATH1);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(allFlower);
            oos.close();

            System.out.println("\nсохранена!\n");

            MainMenu();
        } catch (IOException | MyException e) {
            e.printStackTrace();
        }
    }

    private static void Load() {
        System.out.println("\nЗАГРУЗКА ФАЙЛА:");
        try {
            FileInputStream fis1 = new FileInputStream(FILE_PATH1);
            ObjectInputStream ois1 = new ObjectInputStream(fis1);
            allFlower = (List<Flower>) ois1.readObject();


            System.out.println("\nзагружена!\n");

            MainMenu();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
    }

    private static void ShowListFlower() {
        for (int i = 0; i < allFlower.size(); i++){
            System.out.println(i + ") " + allFlower.get(i));
        }
    }
}