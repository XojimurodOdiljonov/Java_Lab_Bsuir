import Models.Vegetable;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static List<Vegetable> veget = new ArrayList<>();
    public static List<Vegetable> salad = new ArrayList<>();
    private static final String FILE_PATH1 = "ExistedToy.data";
    public static void main(String[] args) throws MyExceptionClass {
        while (true){
            System.out.println("\nГлавный меню: \n" +
                    "1. Добавить овощ\n" +
                    "2. Создать салат\n" +
                    "3. Сортировка овошей по порядку\n" +
                    "4. Поиск овощей по колоридностью\n" +
                    "5. Показать все овощи\n" +
                    "6. Показать овощи в салате\n" +
                    "7. Сохранить\n" +
                    "8. Загрузить\n" +
                    "0. Выход из приложения");

            switch (scanner.nextInt()) {
                case 1: AddVegetable();break;
                case 2: CreateSalad();break;
                case 3: SortVegetableMenu();break;
                case 4: SearchVegetableColorful();break;
                case 5: ViewVegetable();
                case 6: ViewVegetableInSalad();break;
                case 7: SaveVegetable();break;
                case 8: LoadVegetable();break;
                case 0: System.exit(0);break;}
        }
    }

    private static void AddVegetable() throws MyExceptionClass {
        System.out.println("Добавить овощ: \n" +
                "1. Помидок\n" +
                "2. Огурец\n" +
                "3. Лук");

        Vegetable vegetable = new Vegetable();

        switch (scanner.nextInt()) {
            case 1: vegetable.setName("Помидок");MenuColorfulVegetable(vegetable);break;
            case 2: vegetable.setName("Огурец");MenuColorfulVegetable(vegetable);break;
            case 3: vegetable.setName("Лук");MenuColorfulVegetable(vegetable);break;
        }
    }

    private static void MenuColorfulVegetable(Vegetable vegetable)throws MyExceptionClass {
        System.out.println("Укажите колоритность овоща: ");
        int colorfulVegetable = scanner.nextInt();
        if (colorfulVegetable >= 50){
            throw new MyExceptionClass("Введите правильный возвраст");
        }else {
            vegetable.setColorful(colorfulVegetable);
            System.out.println("Укажите стоимость овоща: ");
            vegetable.setPrice(scanner.nextInt());
            veget.add(vegetable);
        }
    }

    private static void CreateSalad () {
        try {
            System.out.println("\nВыберите овощи для салата");
            for (int i = 0; i < veget.size(); i++) {
                System.out.println(i + " " + veget.get(i));
            }

            int choiceVegetableForSalad = scanner.nextInt();
            salad.add(veget.get(choiceVegetableForSalad));
            System.out.println("\nОвощи в салате");
            for (Vegetable v: salad
                ) {
                    System.out.println(v.toString());
                }
            }catch (InputMismatchException e) {
                System.out.println("Не правильный ввод");
            }
    }

    public static void SortVegetableMenu () {
        try {
            System.out.println("1. По убыванию\n" +
                    "2. По возврастанию\n");

            ArrayList<Vegetable> vegetableSort = new ArrayList<>(veget);

            switch (scanner.nextInt()){
                case 1:
                    Collections.sort(vegetableSort);
                    Collections.reverse(vegetableSort);
                    System.out.println(vegetableSort);
                    break;
                case 2:
                    Collections.sort(vegetableSort);
                    System.out.println(vegetableSort);
                    break;
            }
        }catch (InputMismatchException e) {
            System.out.println("Не правильный ввод");
        }
    }

    public static void SearchVegetableColorful () {
        System.out.println("Поис по колорийности - \n" +
                    "Ведите минимальную колорию:");
        int minimumColorful = scanner.nextInt();
        System.out.println("Ведите максимальную колорию:");
        int maximumColorful = scanner.nextInt();

        List<Vegetable> filtered = veget
                .stream()
                .filter(t -> t.getColorful() <= maximumColorful && t.getColorful() >= minimumColorful)
                .collect(Collectors.toList());
        System.out.println(filtered);
    }

    private static void ViewVegetable() {
        System.out.println("Все овощи: ");
        for (int i = 0; i < veget.size(); i++) {
            System.out.println(i + " " + veget.get(i));
        }
    }

    private static void ViewVegetableInSalad() {
        System.out.println("Овощи в салате: ");
        for (Vegetable v: salad
        ) {
            System.out.println(v.toString());
        }
    }

    private static void SaveVegetable() {
        try {
            FileOutputStream fos= new FileOutputStream(FILE_PATH1);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(veget);
            oos.close();

            System.out.println("\nОвощи сохранена!\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void LoadVegetable() {
        System.out.println("\nЗАГРУЗКА ФАЙЛА:");
        try {
            FileInputStream fis1 = new FileInputStream(FILE_PATH1);
            ObjectInputStream ois1 = new ObjectInputStream(fis1);
            veget = (List<Vegetable>) ois1.readObject();


            System.out.println("\nОвощи загружена!\n");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

