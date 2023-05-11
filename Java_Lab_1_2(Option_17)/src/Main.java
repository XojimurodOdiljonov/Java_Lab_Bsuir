import Model.Travel;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Travel> travel = new ArrayList<>();
    private static final String FILE_PATH1 = "ExistedTravel.data";
    public static void main(String[] args) throws MyExceptionClass {
        MainMenu();
    }

    private static void MainMenu() throws MyExceptionClass {
        System.out.println("\nГлавный меню: \n" +
                "1. Добавить путёвки\n" +
                "2. Выбрать путёвку\n" +
                "3. Сортировка\n" +
                "4. Список путёвок\n" +
                "5. Сохранить\n" +
                "6. Загрузить\n" +
                "0. Выход из программы");

        switch (scanner.nextInt()){
            case 1: AddTravel();break;
            case 2: ChoiceTravel();break;
            case 3: SortTravel();break;
            case 4: ShowListTravel();break;
            case 5: SaveTravel();break;
            case 6: LoadTravel();break;
            case 0: System.exit(0);break;
        }
    }

    private static void ShowListTravel() throws MyExceptionClass {
        System.out.println("Список путёвок: ");
        for (int i = 0; i < travel.size(); i++) {
            System.out.println(i + " " + travel.get(i));
        }

        MainMenu();
    }

    private static void SaveTravel() {
        try {
            FileOutputStream fos= new FileOutputStream(FILE_PATH1);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(travel);
            oos.close();

            System.out.println("\nПутёвка сохранена!\n");
            MainMenu();
        } catch (IOException | MyExceptionClass e) {
            e.printStackTrace();
        }
    }

    private static void LoadTravel() {
        System.out.println("\nЗАГРУЗКА ФАЙЛА:");
        try {
            FileInputStream fis1 = new FileInputStream(FILE_PATH1);
            ObjectInputStream ois1 = new ObjectInputStream(fis1);
            travel = (List<Travel>) ois1.readObject();


            System.out.println("\nПутёвка загружена!\n");
            MainMenu();
        } catch (IOException | ClassNotFoundException | MyExceptionClass e) {
            e.printStackTrace();
        }
    }

    private static void AddTravel() throws MyExceptionClass {
        System.out.println("Выберите вид путёвки: \n" +
                "1. Cruise Tour\n" +
                "2. Shopping Tour\n" +
                "3. Relax Tour\n" +
                "4. Excursion Tour\n" +
                "0. Назад\n");

        Travel typeTravel = new Travel();

        switch (scanner.nextInt()){
            case 1: typeTravel.setName("Cruise Tour");TransportTravel(typeTravel);break;
            case 2: typeTravel.setName("Shopping Tour");TransportTravel(typeTravel);break;
            case 3: typeTravel.setName("Relax Tour");TransportTravel(typeTravel);break;
            case 4: typeTravel.setName("Excursion Tour");TransportTravel(typeTravel);break;
            case 0: MainMenu();break;
        }
    }

    private static void TransportTravel(Travel typeTravel) throws MyExceptionClass {
        System.out.println("Выберите транспорт: \n" +
                "1. Самолет\n" +
                "2. Поезд\n" +
                "3. Корабль\n" +
                "4. Машина\n" +
                "0. Выход на главный меню");

        switch (scanner.nextInt()){
            case 1: typeTravel.setTransport("Самолет");PowerSupplyTravel(typeTravel);break;
            case 2: typeTravel.setTransport("Поезд");PowerSupplyTravel(typeTravel);break;
            case 3: typeTravel.setTransport("Корабль");PowerSupplyTravel(typeTravel);break;
            case 4: typeTravel.setTransport("Машина");PowerSupplyTravel(typeTravel);break;
            case 0: MainMenu();break;
        }
    }

    private static void PowerSupplyTravel(Travel typeTravel) throws MyExceptionClass {
        System.out.println("Выберите вид питания: \n" +
                "1. Традиционное\n" +
                "2. Рациональное\n" +
                "3. Диетическое\n" +
                "0. Выход на главный меню");

        switch (scanner.nextInt()){
            case 1: typeTravel.setPowerSupply("Традиционное");TravelDay(typeTravel);break;
            case 2: typeTravel.setPowerSupply("Рациональное");TravelDay(typeTravel);break;
            case 3: typeTravel.setPowerSupply("Диетическое");TravelDay(typeTravel);break;
            case 0: MainMenu(); break;
        }
    }

    private static void TravelDay(Travel typeTravel) throws MyExceptionClass {
        System.out.println("Укажите дней путёвки: \n");
        int dayTravel = scanner.nextInt();
        if (dayTravel >= 360){
            throw new MyExceptionClass("Путёвка не вышу год !");
        }else {
            typeTravel.setDay(dayTravel);
            travel.add(typeTravel);
            MainMenu();
        }
    }

    private static void ChoiceTravel() throws MyExceptionClass {
        System.out.println("Выберите путёвку: ");
        for (int i = 0; i < travel.size(); i++) {
            System.out.println(i + " " + travel.get(i));
        }
        int choiceTravelType = scanner.nextInt();
        System.out.println("Ниже выбранный путёвка: ");
        System.out.println(travel.get(choiceTravelType));

        MainMenu();
    }

    private static void SortTravel() throws MyExceptionClass {
        System.out.println("Сортировка по дней путёвки: \n" +
                "1. По убыванию\n" +
                "2. По возврастанию\n");

        ArrayList<Travel> copy = new ArrayList<>(travel);

        switch (scanner.nextInt()) {
            case 1: Collections.sort(copy); Collections.reverse(copy);System.out.println(copy);MainMenu();break;
            case 2: Collections.sort(copy); System.out.println(copy);MainMenu();break;
            case 0: MainMenu();break;
        }
    }
}