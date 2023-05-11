import Models.Credit;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Credit> credit = new ArrayList<>();
    private static ArrayList<Credit> payOff = new ArrayList<>();
    private static final String FILE_PATH1 = "ExistedCredit.data";
    public static void main(String[] args) throws ExceptionClass {
        MainMenu();
    }

    private static void MainMenu() throws ExceptionClass {
        System.out.println("Выберите кредит на Машину или Дом\n" +
                "1. Выбрать какой кредит\n" +
                "2. Добавить ещё вид кредита\n" +
                "3. Погасить кредит\n" +
                "4. Поиск кредита по диапозане цены кредита\n" +
                "5. Сохранить\n" +
                "6. Загрузить");

        switch (scanner.nextInt()){
            case 1: SelectCredit();break;
            case 2: AddNewCredit();break;
            case 3: PayOffCredit();break;
            case 4: SearchCredit();break;
            case 5: Save(); break;
            case 6: Load(); break;
        }
    }

    public static void SelectCredit() throws ExceptionClass {
        System.out.println("Выберите вид кредита: \n" +
                "1. Машина\n" +
                "2. Дом\n" +
                "0. Назад");

        Credit creditCreate = new Credit();

        switch (scanner.nextInt()){
            case 1: creditCreate.setName("Машина"); SelectCost(creditCreate); break;
            case 2: creditCreate.setName("Дом"); SelectCost(creditCreate); break;
            case 0: MainMenu(); break;
        }
    }

    public static void SelectCost(Credit creditCreate) throws ExceptionClass {
        System.out.println("Сколько денег необходимо для кредита - (Лимит 10.000$)\n" +
                "Укажите цене: ");
        int priceCredit = scanner.nextInt();
        if (priceCredit >= 10000){
            throw new ExceptionClass("Превышен Лимит");
        }else {
            creditCreate.setPrice(priceCredit);
            credit.add(creditCreate);
            MainMenu();
        }
    }

    public static void AddNewCredit() throws ExceptionClass {
        System.out.println("У нас имеется еще вид кредита - Образовательный\n" +
                "1. Выбор Образовательную вид кредита\n" +
                "0. Выход на главный меню");

        int selectedNewCredit = scanner.nextInt();
        if (1 == selectedNewCredit){
            Credit educationCredit = new Credit();
            educationCredit.setName("Образовательный");
            Education(educationCredit);
        }else if (0 == selectedNewCredit){
            MainMenu();
        }
    }

    public static void Education(Credit educationCredit) throws ExceptionClass {
        System.out.println("Сколько денег необходимо для кредита - \n" +
                "Укажите цене: ");

        int educationPriceCredit = scanner.nextInt();
        if (educationPriceCredit >= 10000){
            throw new ExceptionClass("Превышен Лимит");
        }else {
            educationCredit.setPrice(scanner.nextInt());
            credit.add(educationCredit);
            MainMenu();
        }
    }

    public static void PayOffCredit() throws ExceptionClass {
        System.out.println("Выберите вид оплаты: \n" +
                "1. Погасить частично\n" +
                "2. Погасить полностью\n" +
                "0. Выход на главный меню");

        int payOffCredit = scanner.nextInt();
        switch (payOffCredit){
            case 1: PayOffPartly();break;
            case 2: PayOffRemove();break;
            case 0: MainMenu();break;
        }

    }

    private static void PayOffPartly() throws ExceptionClass {
        System.out.println("Сколько денег вы хотите оплатить ");
        int pricePayOff = scanner.nextInt();

        while (true){
            System.out.println("Укажите какую вид кредита хотите оплатить: ");
            for (int i = 0; i < credit.size(); i++) {
                System.out.println(i + " " + credit.get(i));
            }
            int choosingViewCredit = scanner.nextInt();
            payOff.add(credit.get(choosingViewCredit-1));
            pricePayOff -= credit.get(choosingViewCredit-1).getPrice();

            System.out.println("У вас осталось столько кредита: \n" +
                    pricePayOff);
            System.out.println("Для выхода нажмите 1");
            int selectClosed = scanner.nextInt();
            if (1 == selectClosed){
                MainMenu();
            }
        }
    }

    private static void PayOffRemove() throws ExceptionClass {
        System.out.println("Укажите какую вид кредита хотите погасить: ");
        for (int i = 0; i < credit.size(); i++) {
            System.out.println(i + " " + credit.get(i));
        }

        int removeCredit = scanner.nextInt();
        if (removeCredit <= credit.size()) {
            credit.remove(removeCredit - 1);
        }

        System.out.println("0. Назад");
        int back = scanner.nextInt();
        switch (back){
            case 0:
                MainMenu();
                break;
        }
    }

    public static void SearchCredit() throws ExceptionClass {
        System.out.println("Поис по цене кредита - \n" +
                "Ведите минимальную цену-кредита: ");
        int minimumPrice = scanner.nextInt();
        System.out.println("Ведите максимальную цену-кредита:");
        int maximumPrice = scanner.nextInt();

        List<Credit> filtered = credit
                .stream()
                .filter(t -> t.getPrice() <= maximumPrice && t.getPrice() >= minimumPrice)
                .collect(Collectors.toList());
        System.out.println(filtered);

        MainMenu();
    }

    private static void Save() {
        try {
            FileOutputStream fos= new FileOutputStream(FILE_PATH1);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(credit);
            oos.close();

            System.out.println("\nКредит сохранена!\n");
            MainMenu();
        } catch (ExceptionClass e) {
            throw new RuntimeException(e);
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
            credit = (List<Credit>) ois1.readObject();


            System.out.println("\nКредит загружена!\n");
            MainMenu();
        } catch (ExceptionClass e) {
            throw new RuntimeException(e);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}