import Models.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static List<Car> cars = new ArrayList<>();
    private static final String FILE_PATH = "FileCar.data";

    public static void main(String[] args) throws MyException {
        while (true){
            System.out.println("\nМеню: \n" +
                    "Добро Пожаловать!\n" +
                    "1. Добавить машину\n" +
                    "2. Стоимость всех машин\n" +
                    "3. Сортировка по расходу топлива\n" +
                    "4. Посик автомобиля по диапазону скорости\n" +
                    "5. Вывести список автомобилей\n" +
                    "6. Сохранить\n" +
                    "7. Загрузить\n" +
                    "0. Выход из приложения");

            switch (scanner.nextInt()){
                case 1: ListCarMenu();break;
                case 2: PriceAllCar();break;
                case 3: SortCarOil();break;
                case 4: SearchCarSpeed();break;
                case 5: ShowListCar();break;
                case 6: Save();break;
                case 7: Load();break;
                case 0: System.exit(0);break;
            }
        }
    }

    private static void ListCarMenu() throws MyException {
        System.out.println("Выберите автомобиль: \n" +
                "1. Mercedes-Benz\n" +
                "2. BMW\n" +
                "3. Chevrolet\n" +
                "4. Mitsubishi\n" +
                "5. Peugeot\n" +
                "6. Toyota\n");

        Car car = new Car();

        switch (scanner.nextInt()){
            case 1: car.setName("Mercedes-Benz");PriceAuto(car);break;
            case 2: car.setName("BMW");PriceAuto(car);break;
            case 3: car.setName("Chevrolet");PriceAuto(car);break;
            case 4: car.setName("Mitsubishi");PriceAuto(car);break;
            case 5: car.setName("Peugeot");PriceAuto(car);break;
            case 6: car.setName("Toyota");PriceAuto(car);break;
        }
    }

    private static void PriceAuto(Car car) throws MyException {
        System.out.println("Ведите цену автомобиля: ");
        car.setPrice(scanner.nextInt());

        System.out.println("Ведите скорость автомобиля: ");
        int speedCar = scanner.nextInt();
        if (speedCar <= 1228){
            car.setSpeed(speedCar);

            System.out.println("Расход топлива машины: ");
            car.setOil(scanner.nextInt());

            cars.add(car);
        }else {
            throw new MyException("Максимальная автомобилья 1228. Введенно больше чем надо !");
        }
    }

    private static void PriceAllCar() throws MyException {
        int costStation = 0;
        List<Car> copy = new ArrayList<>(cars);
        for (Car car : copy) {
            costStation += car.getPrice();
        }
        System.out.println("Стоимость всех машины: " + Math.round(costStation * 100) / 100);
    }

    public static void SortCarOil() throws MyException {
        System.out.println("1. Сортировка по убыванию\n" +
                "2. Сортировка по возврастанию");

        List<Car> oil = new ArrayList<>(cars);
        switch (scanner.nextInt()){
            case 1:
                Collections.sort(oil);
                Collections.reverse(oil);
                System.out.println(oil);
                break;
            case 2:
                Collections.sort(oil);
                System.out.println(oil);
                break;
        }
    }

    private static void SearchCarSpeed() throws MyException {
        System.out.println("Поис по цене - \n" +
                "Ведите минимальную скорость:");
        int minimumSpeed = scanner.nextInt();
        System.out.println("Ведите максимальную скорость:");
        int maximumSpeed = scanner.nextInt();

        List<Car> filtered = cars
                .stream()
                .filter(t -> t.getSpeed() <= maximumSpeed && t.getSpeed() >= minimumSpeed)
                .collect(Collectors.toList());
        System.out.println(filtered);
    }

    private static void ShowListCar() throws MyException {
        for (int i =0; i < cars.size(); i++){
            System.out.println(i + ")" + cars.get(i));
        }
    }

    private static void Save() {
        try {
            FileOutputStream fos= new FileOutputStream(FILE_PATH);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(cars);
            oos.close();

            System.out.println("\nсохранена!\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void Load() {
        System.out.println("\nЗАГРУЗКА ФАЙЛА:");
        try {
            FileInputStream fis1 = new FileInputStream(FILE_PATH);
            ObjectInputStream ois1 = new ObjectInputStream(fis1);
            cars = (List<Car>) ois1.readObject();


            System.out.println("\nзагружена!\n");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}