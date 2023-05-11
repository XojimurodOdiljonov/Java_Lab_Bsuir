import Models.*;

import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    private static List<Candies> candi = new ArrayList<>();
    private static ArrayList<Candies> gift = new ArrayList<>();
    private static final String FILE_PATH1 = "ExistedCandies.data";
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        while (true) {
            System.out.println("Меню:\n" +
                    "1. Создать Конфету\n" +
                    "2. Собрать подарок по весу\n" +
                    "3. Сортировка по сахара\n" +
                    "4. Поиск\n" +
                    "5. Сериализовать\n" +
                    "6. Десериализовать\n" +
                    "7. Показать десериализованных объектов");

            Candies addCandies = new Candies();

            switch (scanner.nextInt()) {
                case 1: CreateCandies(addCandies);break;
                case 2: CollectCandiesScale();break;
                case 3: SortMenu();break;
                case 4: SearchMenu();break;
                case 5: Save();break;
                case 6: Load();break;
                case 7: ShowListDeserialized();break;
            }
        }
    }

    public static void CreateCandies(Candies addCandies) {
        System.out.println("Выбериту вид конфеты: \n" +
                        "1. Киндер\n"+
                        "2. Кит-Кат\n" +
                        "3. Сникерс\n" +
                        "4. Твих\n");

        switch (scanner.nextInt()){
            case 1:addCandies.setName("Киндер");CollectScale(addCandies);break;
            case 2:addCandies.setName("Кит-Кат");CollectScale(addCandies);break;
            case 3:addCandies.setName("Сникерс");CollectScale(addCandies);break;
            case 4:addCandies.setName("Твих");CollectScale(addCandies);break;
        }
    }

    public static void CollectScale(Candies addCandies) {
        System.out.println("Укажите количество сахара = ");
        addCandies.setSugar(scanner.nextInt());
        System.out.println("Укажите вес конфеты = ");
        addCandies.setScale(scanner.nextInt());

        candi.add(addCandies);
    }

    public static void CollectCandiesScale() {
        System.out.println("Введите вес для подарка: ");
        int scaleCandies = scanner.nextInt();

            System.out.println("Выберите конфету для подарка: ");
            for (int i = 0; i < candi.size(); i++) {
                System.out.println(i + ") " + candi.get(i));
            }
            int choosingCandies = scanner.nextInt();
            gift.add(candi.get(choosingCandies));
            scaleCandies -= candi.get(choosingCandies).getScale();

            System.out.println("У вас осталось столько весса: \n" +
                    scaleCandies);
    }

    public static void SortMenu() {
        System.out.println("Сортировка: ");
        System.out.println("1. По убыванию сахара\n" +
                "2. По возврастанию сахара\n");

        ArrayList<Candies> sort = new ArrayList<>(candi);

        int selectSort = scanner.nextInt();
        switch (selectSort) {
            case 1: Collections.sort(sort);Collections.reverse(sort);System.out.println(sort);break;
            case 2: Collections.sort(sort);System.out.println(sort);break;
        }
    }

    public static void SearchMenu() {
        System.out.println("Поис по весу - \n" +
                "Ведите минимальный весс: ");
        int minimumScale = scanner.nextInt();
        System.out.println("Ведите максимальный весс: ");
        int maximumScale = scanner.nextInt();

        List<Candies> filtered = candi
                .stream()
                .filter(t -> t.getScale() <= maximumScale && t.getScale() >= minimumScale)
                .collect(Collectors.toList());
        System.out.println(filtered);
    }

    private static void Save() throws IOException {
        FileOutputStream fos= new FileOutputStream(FILE_PATH1);
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(candi);
        oos.close();

        System.out.println("\nСохранена!\n");
    }

    private static void Load() throws IOException, ClassNotFoundException {
        FileInputStream fis1 = new FileInputStream(FILE_PATH1);
        ObjectInputStream ois1 = new ObjectInputStream(fis1);
        candi = (List<Candies>) ois1.readObject();

        System.out.println("\nЗагружена!\n");
    }

    private static void ShowListDeserialized() {
        for (int i = 0; i < candi.size(); i++)
            System.out.println(i + ") " + candi.get(i));
    }
}