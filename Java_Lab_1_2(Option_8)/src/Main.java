import Model.Railway;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Railway> railway = new ArrayList<Railway>();
    private static final String FILE_PATH1 = "ExistedToy.data";
    public static void main(String[] args) {
        while (true){
            System.out.println("\nГлавный меню: \n" +
                    "1. Создать вагон\n" +
                    "2. Вывести количество посажиров и богаж\n" +
                    "3. Провести сортировку по комфортности\n" +
                    "4. Поиск\n" +
                    "5. Список добавленных\n" +
                    "6. Сохранить\n" +
                    "7. Загрузить\n" +
                    "8. Показать сохраненных" +
                    "0. Выйти из программы");

            switch (scanner.nextInt()) {
                case 1: CreateRailway();break;
                case 2: OutQuantityPeople();break;
                case 3: SortByComfort();break;
                case 4: SearchRailway();break;
                case 5: ShowList();break;
                case 6: SaveRailway(); break;
                case 7: LoadRailway(); break;
                case 8: ShowList();
                case 0: System.exit(0);break;}
        }
    }

    private static void CreateRailway() {
        System.out.println("\nВведите Id Вагоны");

        Railway railwayPerson = new Railway();
        railwayPerson.setId(scanner.nextInt());

        System.out.println("\nДоваить богаж: ");
        railwayPerson.setBag(scanner.nextInt());

        System.out.println("\nВести: ");
        System.out.println("Количество посажиров в вагоне: ");
        railwayPerson.setQuantity(scanner.nextInt());

        System.out.println("Введите уровень комфортности: \n");
        railwayPerson.setComfort(scanner.nextInt());
        railway.add(railwayPerson);
    }

    private static void OutQuantityPeople() {
        System.out.println("Вывод параметров\n" +
                "1. Вывысти количество посажиров и количество богажа\n");

        int choiceItemPeopleAndBag = scanner.nextInt();
        switch (choiceItemPeopleAndBag) {
            case 1:
                for (int i = 0; i < railway.size(); i++) {
                    System.out.println(railway.get(i));
                }break;
        }
    }

    private static void SortByComfort() {
            System.out.println("1. По убыванию\n" +
                    "2. По возврастанию\n");

            ArrayList<Railway> copy = new ArrayList<>(railway);

            switch (scanner.nextInt()) {
                case 1:
                    Collections.sort(copy);
                    Collections.reverse(copy);
                    System.out.println(copy);
                    break;
                case 2:
                    Collections.sort(copy);
                    System.out.println(copy);
                    break;
            }
    }

    private static void SearchRailway() {
            System.out.println("Поис по количество посажиров - \n" +
                    "Ведите минимальную цыфру:");
            int minimumNum = scanner.nextInt();
            System.out.println("Ведите максимальную цыфру:");
            int maximumNum = scanner.nextInt();

            List<Railway> filtered = railway
                    .stream()
                    .filter(t -> t.getQuantity() <= maximumNum && t.getQuantity() >= minimumNum)
                    .collect(Collectors.toList());
            System.out.println(filtered);
    }

    private static void SaveRailway() {
        try {
            FileOutputStream fos= new FileOutputStream(FILE_PATH1);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(railway);
            oos.close();

            System.out.println("\nВагоны сохранена!\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void LoadRailway() {
        System.out.println("\nЗАГРУЗКА ФАЙЛА:");
        try {
            FileInputStream fis1 = new FileInputStream(FILE_PATH1);
            ObjectInputStream ois1 = new ObjectInputStream(fis1);
            railway = (List<Railway>) ois1.readObject();


            System.out.println("\nВагоны загружена!\n");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void ShowList() {
        for (int i = 0; i < railway.size(); i++) {
            System.out.println(railway.get(i));
        }
    }
}