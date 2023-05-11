import Model.Passenger;
import Model.Trip;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //Пароль Администратора: 1111
    private static Scanner scanner = new Scanner(System.in);
    private static List<Trip> listTrip = new ArrayList<>();
    private static List<Passenger> listPassenger = new ArrayList<>();
    private static List listBuyTrip = new ArrayList();
    private static List listSelectedTrip = new ArrayList();
    private static final String FILE_PATH1 = "ExistedTrip.data";
    private static final String FILE_PATH2 = "ExistedPassenger.data";
    public static void main(String[] args) throws FileNotFoundException, MyException {
        while (true){
            System.out.println("Меню: \n" +
                    "1. Добавить поездку (Администратор)\n" +
                    "2. Сделать заявку (Купить Билет)\n" +
                    "3. Показать оплаченных поездов и посажиров\n" +
                    "4. Сериализовать\n" +
                    "5. Десериализовать\n" +
                    "6. Показать объектов после Десериализации");

            Trip createTrip = new Trip();

            switch (scanner.nextInt()){
                case 1:AddTrip(createTrip);break;
                case 2:MakeRequest(createTrip);break;
                case 3:ShowList();break;
                case 4:SerializableClass();break;
                case 5:DeSerializableClass();break;
                case 6:ShowListDeSerializableClass();break;
            }
        }
    }

    private static void AddTrip(Trip createTrip) {
        System.out.println("Введите пароль Администратора");
        int passwordAdmin = scanner.nextInt();
        if (passwordAdmin == 1111){
            System.out.println("--------------\n" +
                    "Введите номер Поезда\n" +
                    "Пример: 101-98");
            createTrip.setNumberTrain(scanner.next());

            System.out.println("Введите время начало поездки\n" +
                    "Пример: 10:00");
            createTrip.setTimeTrain(scanner.next());

            System.out.println("Введите конечную станцию поездку\n" +
                    "Пример: Гомель");
            createTrip.setTerminalStation(scanner.next());

            System.out.println("Введите цену: \n" +
                    "Пример: 1000");
            createTrip.setPriceTrip(scanner.nextInt());

            listTrip.add(createTrip);

            System.out.println("Поездка созданна !!");
        }else {
            System.out.println("Вы вели не правильный пароль!");
            AddTrip(createTrip);
        }
    }

    private static void MakeRequest(Trip createTrip) throws MyException {
        System.out.println("--------------\n" +
                "Введите станцию куда хотели бы поехать: ");
        String stationPassenger = scanner.next();

        System.out.println("Введите время поездки: ");
        String time = scanner.next();

        System.out.println("Дата поездки: ");
        String date = scanner.next();

        Passenger createPassenger = new Passenger(stationPassenger, time, date);
        listPassenger.add(createPassenger);

        System.out.println("Вот сущестующие Поезкди: ");
        for (int i = 0; i < listTrip.size(); i++){
            System.out.println(i + ") " + listTrip.get(i));
        }

        System.out.println("Выберите");
        int choosingTrip = scanner.nextInt();
        listSelectedTrip.add(listTrip.get(choosingTrip));
        System.out.println("\nВыбранная поездка");
        System.out.println(listSelectedTrip);
        System.out.println(createTrip.getPriceTrip());
        System.out.println("\nВведите цену поездки как указанно с верху");
        int priceTrip = scanner.nextInt();

        if (priceTrip >= 10000){
            throw new MyException("Введите меньше 10.000");
        }else {
            listBuyTrip.add(listSelectedTrip);
            System.out.println("Отлично всё оплаченно !!");
        }
    }

    private static void ShowList() {
        System.out.println("Список оплаченных пассажиров и куда они едут\n");
        for (int i = 0; i < listBuyTrip.size();i++)
            System.out.println(i + ") " + listBuyTrip.get(i));

        System.out.println("Список закончен !");
    }

    private static void SerializableClass() {
        try {
            FileOutputStream fos= new FileOutputStream(FILE_PATH1);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(listTrip);
            oos.close();

            FileOutputStream fos1 = new FileOutputStream(FILE_PATH2);
            ObjectOutputStream oos1 =new ObjectOutputStream(fos1);
            oos1.writeObject(listPassenger);
            oos.close();

            System.out.println("\nсохранена!\n");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void DeSerializableClass() throws FileNotFoundException {
        System.out.println("\nЗАГРУЗКА ФАЙЛА:");
        try {
            FileInputStream fis1 = new FileInputStream(FILE_PATH1);
            ObjectInputStream ois1 = new ObjectInputStream(fis1);
            listTrip = (List<Trip>) ois1.readObject();

            FileInputStream fis2 = new FileInputStream(FILE_PATH2);
            ObjectInputStream ois2 = new ObjectInputStream(fis2);
            listPassenger = (List<Passenger>) ois2.readObject();

            System.out.println("\nзагружена!\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void ShowListDeSerializableClass() {
        System.out.println("Сериализованные Поездки");
        for (int i = 0; i < listTrip.size(); i++)
            System.out.println(i + ") " + listTrip.get(i));

        System.out.println("Сериализованные Пассажиры");
        for (int i = 0; i < listPassenger.size(); i++)
            System.out.println(i + ") " + listPassenger.get(i));
    }
}

