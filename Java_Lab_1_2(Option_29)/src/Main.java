import Model.Transport;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Transport addTransport = new Transport(true);
    private static List<Transport> transportModel = new ArrayList<>();
    private static ArrayList<Transport> routeTransport = new ArrayList<>();
    private static ArrayList<Transport> breakdownTransport = new ArrayList<>();
    private static ArrayList<Transport> increaseIntervalTimeTransport = new ArrayList<>();
    private static final String FILE_PATH1 = "ExistedTransport.data";
    public static void main(String[] args) throws MyException {
        MainMenu();
    }

    private static void MainMenu() throws MyException {
        System.out.println("\nГлавный Меню: \n" +
                "1. Добавить Транспорт\n" +
                "2. Показать Транспортов\n" +
                "3. Добавить маршрут\n" +
                "4. Поломка маршрута\n" +
                "5. Список поломки\n" +
                "6. Увеличить интервал времени\n" +
                "7. Сохранть\n" +
                "8. Загрузить\n" +
                "0. Выход из программы");

        int choiceMenu = scanner.nextInt();
        switch (choiceMenu) {
            case 1: CreateRoute();break;
            case 2: ShowTransport();break;
            case 3: AddRoute();break;
            case 4: BreakdownRoute();break;
            case 5: ShowBreakdownTransport();break;
            case 6: IncreaseIntervalTime(addTransport);break;
            case 7: Save();break;
            case 8: Load();break;
            case 0: System.exit(0);break;
        }
    }

    private static void Save() {
        try {
            FileOutputStream fos= new FileOutputStream(FILE_PATH1);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(transportModel);
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
            transportModel = (List<Transport>) ois1.readObject();


            System.out.println("\nзагружена!\n");

            MainMenu();
        } catch (IOException | ClassNotFoundException | MyException e) {
            e.printStackTrace();
        }
    }

    private static void CreateRoute() throws MyException {
        System.out.println("Введите навзания транспорта: ");

        Transport addTransport = new Transport(true);
        addTransport.setName(scanner.next());

        System.out.println("Введите скорость транспорта: ");
        int speedTransport = scanner.nextInt();
        if (speedTransport >= 500){
            throw new MyException("Введите меньше 500км/ч");
        }else {
            addTransport.setSpeed(speedTransport);
            System.out.println("Введите интервал времени: ");
            addTransport.setInterval(scanner.nextInt());
            addTransport.setState(true);
            transportModel.add(addTransport);

            MainMenu();
        }
    }

    private static void ShowTransport() throws MyException {
        for (int i = 0; i < transportModel.size(); i++){
            System.out.println(i + ") " + transportModel.get(i));
        }

        MainMenu();
    }

    private static void AddRoute() throws MyException {
        for (int i = 0; i < transportModel.size(); i++){
            System.out.println(i + ") " + transportModel.get(i));
        }
        System.out.println("Выберите транспорт для маршрута");
        int choiceRouteTransport = scanner.nextInt();
        routeTransport.add(transportModel.get(choiceRouteTransport));
        System.out.println("Выбранный маршрут: ");
        for (Transport v: routeTransport){
            System.out.println(v.toString());
        }

        MainMenu();
    }

    private static void BreakdownRoute() throws MyException {
        for (int i = 0; i < routeTransport.size(); i++){
            System.out.println(i + ") " + routeTransport.get(i));
        }
        System.out.println("Выберите маршрута для поломки");
        int routeBreakdown = scanner.nextInt();
        routeTransport.get(routeBreakdown).setState(false);
        breakdownTransport.add(routeTransport.get(routeBreakdown));

        MainMenu();
    }

    private static void ShowBreakdownTransport() throws MyException {
        System.out.println("Список поломки: ");
        for (Transport v: breakdownTransport){
            System.out.println(v.toString());
        }
        MainMenu();
    }

    private static void IncreaseIntervalTime(Transport addTransport) throws MyException {
        for (int i = 0; i < transportModel.size(); i++){
            System.out.println(i + ") " + transportModel.get(i));
        }
        System.out.println("Выберите транспорт: ");
        int choiceIntervalTime = scanner.nextInt();
        increaseIntervalTimeTransport.add(transportModel.get(choiceIntervalTime));
        System.out.println("Введите интервал: ");
        int addIntervalTime = scanner.nextInt();
        

        for (Transport v: increaseIntervalTimeTransport){
            System.out.println(v.toString());
        }
        MainMenu();
    }
}
