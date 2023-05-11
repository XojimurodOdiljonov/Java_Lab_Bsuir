import Model.Stone;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Stone> stone = new ArrayList<>();
    private static final String FILE_PATH1 = "ExistedStone.data";
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        while (true){
            System.out.println("\nГлавный меню: \n" +
                    "1. Добавить камень\n" +
                    "2. Выбрать камень для ожерелья\n" +
                    "3. Вывести весс и стоимость камней\n" +
                    "4. Сортировка\n" +
                    "5. Поиск\n" +
                    "6. Сохранить\n" +
                    "7. Загрузить\n" +
                    "8. Показать список после загрузки\n" +
                    "0. Выход");

            switch (scanner.nextInt()){
                case 1: AddStone();break;
                case 2: ChoiceStoneOfNecklace();break;
                case 3: OutputWeightValueStone();break;
                case 4: SortOfStone();break;
                case 5: SearchStone();break;
                case 6: Save();break;
                case 7: Load();break;
                case 8: ShowList();break;
                case 0: System.exit(0);break;
            }
        }
    }

    private static void AddStone() {
        System.out.println("Выберите вид камня" +
                "Драгоценные камни: \n" +
                "1. Изумруд\n" +
                "2. Алмаз\n" +
                "Полудрагоценные камни" +
                "3. Аметрин\n" +
                "4. Диаспор\n");

        Stone typeOfStone = new Stone();
        switch (scanner.nextInt()){
            case 1:
                typeOfStone.setName("Изумруд");
                System.out.println("Укажите весс: ");
                typeOfStone.setWeightStone(scanner.nextInt());
                PriceTypeOfStone(typeOfStone);
                break;
            case 2:
                typeOfStone.setName("Алмаз");
                System.out.println("Укажите весс: ");
                typeOfStone.setWeightStone(scanner.nextInt());
                PriceTypeOfStone(typeOfStone);
                break;
            case 3:
                typeOfStone.setName("Аметрин");
                System.out.println("Укажите весс: ");
                typeOfStone.setWeightStone(scanner.nextInt());
                PriceTypeOfStone(typeOfStone);
                break;
            case 4:
                typeOfStone.setName("Диаспор");
                System.out.println("Укажите весс: ");
                typeOfStone.setWeightStone(scanner.nextInt());
                PriceTypeOfStone(typeOfStone);
                break;
        }
    }

    private static void PriceTypeOfStone(Stone typeOfStone) {
        System.out.println("Укажите стоимость: ");
        typeOfStone.setPriceStone(scanner.nextInt());

        stone.add(typeOfStone);
    }

    private static void ChoiceStoneOfNecklace() {
        System.out.println("Весь список камней:...............\n");
        for (int i = 0; i < stone.size(); i++) {
            System.out.println(i + " " + stone.get(i));
        }
        System.out.println("Выберите камень для ожерелья\n");
        int choiceStoneOfNecklace = scanner.nextInt();
        System.out.println("Ниже выбранный камень для ожерелья:");
        System.out.println(stone.get(choiceStoneOfNecklace));
    }

    private static void OutputWeightValueStone() {
        int sumWeightStone = stone.stream().mapToInt(Stone::getWeightStone).sum();
        int sumPriceStone = stone.stream().mapToInt(Stone::getPriceStone).sum();
        System.out.println("Общий весс камней: " + sumWeightStone + " в каратах" + "\n" +
                "Общий цена камней: " + sumPriceStone + "$");
    }

    private static void SortOfStone() {
        System.out.println("1. По убыванию\n" +
                "2. По возврастанию\n");

        ArrayList<Stone> copy = new ArrayList<>(stone);

        switch (scanner.nextInt()) {
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

    private static void SearchStone() {
        System.out.println("Поис по цене - \n" +
                "Ведите минимальную цену:");
        int minimumWeight = scanner.nextInt();
        System.out.println("Ведите максимальную цену:");
        int maximumWeight = scanner.nextInt();

        List<Stone> filtered = stone
                .stream()
                .filter(t -> t.getWeightStone() <= maximumWeight && t.getWeightStone() >= minimumWeight)
                .collect(Collectors.toList());
        System.out.println(filtered);
    }

    private static void Save() throws IOException {
        FileOutputStream fos= new FileOutputStream(FILE_PATH1);
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(stone);
        oos.close();

        System.out.println("\nСохранена!\n");
    }

    private static void Load() throws IOException, ClassNotFoundException {
        System.out.println("\nЗАГРУЗКА ФАЙЛА:");

        FileInputStream fis1 = new FileInputStream(FILE_PATH1);
        ObjectInputStream ois1 = new ObjectInputStream(fis1);
        stone = (List<Stone>) ois1.readObject();

        System.out.println("\nЗагружена!\n");
    }

    private static void ShowList() {
        for (int i = 0; i < stone.size(); i++)
            System.out.println(i + ") " + stone.get(i));
    }
}
