import Model.Insurance;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Insurance> insurances = new ArrayList<>();
    private static final String FILE_PATH1 = "ExistedInsurance.data";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        while (true){
            System.out.println("\nГлавный меню: \n" +
                    "1. Выбрать вид страхования\n" +
                    "2. Общая сумма\n" +
                    "3. Сортировка по риска\n" +
                    "4. Поиск\n" +
                    "5. Показать весь список\n" +
                    "6. Сохранить\n" +
                    "7. Загрузить\n" +
                    "8. Показать сохраненных\n" +
                    "0. Выход");

            switch (scanner.nextInt()){
                case 1: ChoiceInsurance();break;
                case 2: TotalInsurance();break;
                case 3: SortInsurance();break;
                case 4: SearchInsurance();break;
                case 5: AllListInsurance();break;
                case 6: Save();break;
                case 7: Load();break;
                case 8: ShowList();break;
                case 0: System.exit(0);break;
            }
        }
    }

    private static void ChoiceInsurance() {
        System.out.println("Выберите вид страхования: \n" +
                "1. Стахования имущества\n" +
                "2. Страхования от огня\n" +
                "3. Личное страхование");

        Insurance derivativeInsurance = new Insurance();

        switch (scanner.nextInt()){
            case 1:
                derivativeInsurance.setName("Стахования имущества");
                InsuranceCost(derivativeInsurance);
                break;
            case 2:
                derivativeInsurance.setName("Страхования от огня");
                InsuranceCost(derivativeInsurance);
                break;
            case 3:
                derivativeInsurance.setName("Личное страхование");
                InsuranceCost(derivativeInsurance);
                break;
        }
    }

    private static void InsuranceCost(Insurance derivativeInsurance) {
        System.out.println("Укажите сумму к страхованию: ");
        derivativeInsurance.setCost(scanner.nextInt());
        System.out.println("Укажите риск: ");
        derivativeInsurance.setRisk(scanner.nextInt());
        insurances.add(derivativeInsurance);
    }

    private static void TotalInsurance() {
        int sumInsurance = insurances.stream().mapToInt(Insurance::getCost).sum();
        System.out.println("Общая сумма страховки: " + sumInsurance);
    }

    private static void SortInsurance() {
        System.out.println("1. По убыванию\n" +
                "2. По возврастанию\n");

        ArrayList<Insurance> copy = new ArrayList<>(insurances);

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

    private static void SearchInsurance() {
        System.out.println("Поис по сумме - \n" +
                "Ведите минимальную сумму:");
        int minimumWeight = scanner.nextInt();
        System.out.println("Ведите максимальную сумму:");
        int maximumWeight = scanner.nextInt();

        List<Insurance> filtered = insurances
                .stream()
                .filter(t -> t.getCost() <= maximumWeight && t.getCost() >= minimumWeight)
                .collect(Collectors.toList());
        System.out.println(filtered);
    }

    private static void AllListInsurance() {
        for (int i = 0; i < insurances.size(); i++) {
            System.out.println(i + ") " + insurances.get(i));
        }
    }

    private static void Save() throws IOException {
        FileOutputStream fos= new FileOutputStream(FILE_PATH1);
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        oos.writeObject(insurances);
        oos.close();

        System.out.println("\nсохранена!\n");
    }

    private static void Load() throws IOException, ClassNotFoundException {
        System.out.println("\nЗАГРУЗКА ФАЙЛА:");

        FileInputStream fis1 = new FileInputStream(FILE_PATH1);
        ObjectInputStream ois1 = new ObjectInputStream(fis1);
        insurances = (List<Insurance>) ois1.readObject();


        System.out.println("\nзагружена!\n");
    }

    private static void ShowList() {
        for (int i = 0; i < insurances.size(); i++) {
            System.out.println(i + ") " + insurances.get(i));
        }
    }
}