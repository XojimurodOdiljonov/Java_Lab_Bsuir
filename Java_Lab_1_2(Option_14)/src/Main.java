import Model.Toy;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Toy> existedToy = new ArrayList<>();
    private static List<Toy> toyOnDisk = new ArrayList<>();
    private static final String FILE_PATH1 = "ExistedToy.data";

    public static void main(String[] args) throws MyExceptionClass {
        while (true) {
            System.out.println("\nМеню:\n" +
                    "1. Создать игрушки\n" +
                    "2. Создать комнату\n" +
                    "3. Удалить игрушку\n" +
                    "4. Сортировка\n" +
                    "5. Поиск\n" +
                    "6. Список игрушек\n" +
                    "7. Сохранить\n" +
                    "8. Загрузить\n" +
                    "0. Выйти из приложения");

            switch (scanner.nextInt()) {
                case 1: {AddToyMenu();break;}
                case 2: {CreateRoom();break;}
                case 3: {RemoveToys();break;}
                case 4: {SortMenu();break;}
                case 5:{SearchMenu(); break;}
                case 6:{ShowToys(); break;}
                case 7:{SaveToyInFile(); break;}
                case 8:{LoadFile(); break;}
                case 0: {System.exit(0);break;}
            }
        }
    }

    private static void AddToyMenu() throws MyExceptionClass { // функция создания новой игрушка
        System.out.print("Название игрушки: ");
        String newToyName = scanner.next();

        System.out.print("Размер игрушки: ");
        String sizeToy = scanner.next();

        System.out.print("Введите цену: ");
        int priceToy = scanner.nextInt();

        System.out.println("Введите возвраст: ");
        int addAge = scanner.nextInt();
        if (addAge >= 100) {
            throw new MyExceptionClass("Введите правильный возвраст");
        } else {
            Toy newToy = new Toy(newToyName, sizeToy, priceToy, addAge);
            existedToy.add(newToy);
        }
    }

    private static void CreateRoom() {
        System.out.println("Ведите сумму денег комнате: ");
        int priceRoom = scanner.nextInt();

        System.out.println("Выберите игрушку для комнаты: ");
        for (int i = 0; i < existedToy.size(); i++) {
            System.out.println(i + " " + existedToy.get(i));
        }
        int choosingToy = scanner.nextInt();
        toyOnDisk.add(existedToy.get(choosingToy));
        priceRoom -= toyOnDisk.get(choosingToy).getCost();

        System.out.println("У вас осталось столько денег: \n" +
                priceRoom);
    }

    private static void RemoveToys() {
        System.out.println("Выбрать игрушеку чтобы удалить: ");
        for (int i = 0; i < existedToy.size(); i++) {
            System.out.println(i + " " + existedToy.get(i));
        }

        int removeToy = scanner.nextInt();
        if (removeToy <= existedToy.size()) {
            existedToy.remove(removeToy - 1);
        }
    }

    private static void SortMenu(){
        System.out.println("1. По убыванию\n" +
                "2. По возврастанию\n");

        List<Toy> copy = new ArrayList<>(existedToy);

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

    private static void SearchMenu() {
        System.out.println("Поис по цене - \n" +
                "Ведите минимальную цену:");
        int minimumPrice = scanner.nextInt();
        System.out.println("Ведите максимальную цену:");
        int maximumPrice = scanner.nextInt();

        List<Toy> filtered = existedToy
                .stream()
                .filter(t -> t.getCost() <= maximumPrice && t.getCost() >= minimumPrice)
                .collect(Collectors.toList());
        System.out.println(filtered);
    }

    private static void SaveToyInFile() {
        try {
            FileOutputStream fos= new FileOutputStream(FILE_PATH1);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(existedToy);
            oos.close();

            System.out.println("\nИгрушка сохранена!\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void LoadFile() {
        System.out.println("\nЗАГРУЗКА ФАЙЛА:");
        try {
            FileInputStream fis1 = new FileInputStream(FILE_PATH1);
            ObjectInputStream ois1 = new ObjectInputStream(fis1);
            existedToy = (List<Toy>) ois1.readObject();


            System.out.println("\nИгрушка загружена!\n");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void ShowToys() {
        for (int i = 0; i < existedToy.size(); i++) {
            System.out.println(i + " " + existedToy.get(i));
        }
    }
}