import Models.Equip;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Equip> createEquips = new ArrayList<>();
    private static List<Equip> equips = new ArrayList<>();
    private static final String FILE_PATH1 = "ExistedEquip.data";
    public static void main(String[] args) throws MyExceptionClass, IOException {
        while (true){
            System.out.println("Главный меню: \n" +
                    "1. Создать Экипировку\n" +
                    "2. Присвоить созданные экипировки к мотоциклисту\n" +
                    "3. Просмотр созданные экипировки к мотоциклисту\n" +
                    "4. Сортировка\n" +
                    "5. Поиск\n" +
                    "6. Сохранить\n" +
                    "7. Загрузить\n" +
                    "8. Показать сохранённых объектов");

            switch (scanner.nextInt()){
                case 1: CreateEquip(); break;
                case 2: AddPersonEquip(); break;
                case 3: ShowAddCreateEquip(); break;
                case 4: Sort(); break;
                case 5: Search(); break;
                case 6: Save(); break;
                case 7: Load(); break;
                case 8: ShowList(); break;
            }
        }
    }

    private static void CreateEquip() throws MyExceptionClass {
        System.out.println("Введите название");
        Equip createEquip = new Equip();
        createEquip.setName(scanner.next());

        System.out.println("Введите вес: ");
        int addWeight = scanner.nextInt();
        if (addWeight >= 1000){
            throw new MyExceptionClass("Введите меньше 1000 грамм");
        }else {
            createEquip.setWeight(addWeight);

            System.out.println("Введите цена: ");
            createEquip.setPrice(scanner.nextInt());

            System.out.println("Выберите одежду: \n" +
                    "1. Шлем \n" +
                    "2. Жекет \n" +
                    "3. Штаны \n" +
                    "4. Обувь");
            switch (scanner.nextInt()){
                case 1: createEquip.setHead("Шлем"); equips.add(createEquip);break;
                case 2: createEquip.setSuit("Жекет"); equips.add(createEquip);break;
                case 3: createEquip.setPants("Штаны"); equips.add(createEquip);break;
                case 4: createEquip.setShoes("Обувь"); equips.add(createEquip);break;
            }
        }
    }

    private static void AddPersonEquip() throws MyExceptionClass {
        System.out.println("Выберите экипировку: ");
        for (int i = 0; i < equips.size(); i++){
            System.out.println(i + " " + equips.get(i));
        }
        int choiceEquip = scanner.nextInt();
        equips.get(choiceEquip);
        createEquips.add(equips.get(choiceEquip));
    }

    private static void ShowAddCreateEquip(){
        System.out.println("Присвоенный лист\n");
        for (int i = 0; i < createEquips.size(); i++){
            System.out.println(i + " " + createEquips.get(i));
        }
    }

    private static void Sort() throws MyExceptionClass {
        System.out.println("1. Сортировка по убыванию\n" +
                "2. Сортировка по возрастанию \n");

        ArrayList<Equip> sort = new ArrayList<>(equips);
        switch (scanner.nextInt()){
            case 1:
                Collections.sort(sort);
                Collections.reverse(sort);
                System.out.println(sort);
                break;
            case 2:
                Collections.sort(sort);
                System.out.println(sort);
                break;
        }
    }

    private static void Search() throws MyExceptionClass {
        System.out.println("Поиск по весу - \n" +
                "Введите минимальную вес:");
        int minimumNum = scanner.nextInt();
        System.out.println("Введите максимальную вес:");
        int maximumNum = scanner.nextInt();

        List<Equip> filtered = equips
                .stream()
                .filter(t -> t.getWeight() <= maximumNum && t.getWeight() >= minimumNum)
                .collect(Collectors.toList());
        System.out.println(filtered);
    }

    private static void Save() throws IOException {
        try {
            FileOutputStream fos= new FileOutputStream(FILE_PATH1);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(equips);
            oos.close();

            System.out.println("\n Экипировка сохранена!\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void Load() {
        System.out.println("\n ЗАГРУЗКА ФАЙЛА:");
        try {
            FileInputStream fis1 = new FileInputStream(FILE_PATH1);
            ObjectInputStream ois1 = new ObjectInputStream(fis1);
            equips = (List<Equip>) ois1.readObject();


            System.out.println("\n Экипировка загружена!\n");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void ShowList() throws MyExceptionClass {
        System.out.println("Список экипировки\n");
        for (int i = 0; i < equips.size(); i++){
            System.out.println(i + " " + equips.get(i));
        }
    }
}