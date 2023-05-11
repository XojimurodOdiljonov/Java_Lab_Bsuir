import Model.Airline;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static  List<Airline> air = new ArrayList<>();
    private static ArrayList<Airline> airRoom = new ArrayList<>();
    private static final String FILE_PATH1 = "ExistedPlane.data";

    public static void main(String[] args) throws MyException {
        while (true){
            System.out.println("\nМеню:\n" +
                    "1. Создать самолет\n" +
                    "2. Вывести созданный самолет\n" +
                    "3. Создать авиакомпанию\n" +
                    "4. Посчитать общую вместимость и грузоподъемность\n" +
                    "5. Сортировка\n" +
                    "6. Поиск\n" +
                    "7. Сохранить\n" +
                    "8. Загрузить\n" +
                    "0. Выйти из приложения");

            switch (scanner.nextInt()) {
                case 1: CreatePlane();break;
                case 2: ShowListPlane();break;
                case 3: CreateAirline();break;
                case 4: CalculatePlane();break;
                case 5: SortPlane();break;
                case 6: SearchPlane();break;
                case 7: Save();break;
                case 8: Load();break;
                case 0: System.exit(0);break;
            }
        }
    }

    private static void CreatePlane() throws MyException {
        System.out.println("Введите названия самолета: ");
        Airline planeType = new Airline();
        planeType.setName(scanner.next());

        System.out.println("Введите стоимость самолета: ");
        planeType.setPrice(scanner.nextInt());

        System.out.println("Введите вместимость самолета: ");
        int capacityPlane = scanner.nextInt();
        if (capacityPlane >= 700){
            throw new MyException("Больше 700 пассажиров не совмешаеться");
        }else {
            planeType.setCapacity(capacityPlane);
            System.out.println("Введите грузоподъемность самолета: ");
            planeType.setLoadCapacity(scanner.nextInt());

            System.out.println("Введите дальность самолета: ");
            planeType.setFlightRange(scanner.nextInt());

            System.out.println("Введите расход бензина: ");
            planeType.setGasolineConsumption(scanner.nextInt());
            air.add(planeType);
        }
    }

    private static void ShowListPlane() throws MyException {
        System.out.println("Список самолетов: ");
        for (int i = 0; i < air.size(); i++){
            System.out.println(i + ") " + air.get(i));
        }
    }

    private static void CreateAirline() throws MyException {
        System.out.println("Ведите сумму денег для самолета: ");
        int pricePlane = scanner.nextInt();

            System.out.println("Выберите самолет для авиакомпании: ");
            for (int i = 0; i < air.size(); i++) {
                System.out.println(i + ") " + air.get(i));
            }
            int choosingPlane = scanner.nextInt();
            airRoom.add(air.get(choosingPlane));
            pricePlane -= airRoom.get(choosingPlane).getPrice();

            System.out.println("У вас осталось столько денег: \n" +
                    pricePlane);

    }

    private static void CalculatePlane() throws MyException {
        System.out.println("Выберите пункт: \n" +
                "1. Посчитать общую вместимость\n" +
                "2. Посчитать общую грузоподъемность\n");

        switch (scanner.nextInt()) {
            case 1:
                int sum = air.stream().mapToInt(Airline::getCapacity).sum();
                System.out.println("Общая вместимость: " + sum);
                break;
            case 2:
                int all = air.stream().mapToInt(Airline::getLoadCapacity).sum();
                System.out.println("Общая грузоподъемность: " + all);
                break;
        }
    }

    private static void SortPlane() throws MyException {
        System.out.println("1. По убыванию мощностей\n" +
                "2. По возврастанию мощностей\n");

        ArrayList<Airline> copy = new ArrayList<>(air);

        int selectSort = scanner.nextInt();
        switch (selectSort) {
            case 1:
                Collections.sort(copy);
                System.out.println(copy);
                break;
            case 2:
                Collections.sort(copy);
                Collections.reverse(copy);
                System.out.println(copy);
                break;
        }
    }

    private static void SearchPlane() throws MyException {
        System.out.println("Поис по потребления горючего - \n" +
                "Ведите минимальную расход бензина: ");
        int minimumGasoline = scanner.nextInt();
        System.out.println("Ведите максимальную расход бензина: ");
        int maximumGasoline = scanner.nextInt();

        List<Airline> filtered = air
                .stream()
                .filter(t -> t.getGasolineConsumption() <= maximumGasoline && t.getGasolineConsumption() >= minimumGasoline)
                .collect(Collectors.toList());
        System.out.println(filtered);
    }

    private static void Save() {
        try {
            FileOutputStream fos= new FileOutputStream(FILE_PATH1);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(air);
            oos.close();

            System.out.println("\nСохранена!\n");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void Load() {
        System.out.println("\nЗАГРУЗКА ФАЙЛА:");
        try {
            FileInputStream fis1 = new FileInputStream(FILE_PATH1);
            ObjectInputStream ois1 = new ObjectInputStream(fis1);
            air = (List<Airline>) ois1.readObject();


            System.out.println("\nЗагружена!\n");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}